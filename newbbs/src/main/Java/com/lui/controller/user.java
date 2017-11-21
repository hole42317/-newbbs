package com.lui.controller;

import com.lui.db.announces.AnnouncesEntity;
import com.lui.db.announces.ReplyEntity;
import com.lui.db.login.LoginEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.expression.Expression;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lui on 2017/11/21.
 */
@Controller
@SessionAttributes(value = "user")
public class user {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "loginResult",method = RequestMethod.POST)
    public String loginResult(ModelMap map, @RequestParam String userName, @RequestParam String userPassword,HttpServletRequest request){
//        map.addAttribute("userName",userName);
//        map.addAttribute("userPassword",userPassword);
        LoginEntity user = new LoginEntity();
        user.setUserName(userName);
        user.setUserPassword(userPassword);

        conn conn = new conn();
        Session session = conn.getSession();
        List<LoginEntity> users = session.createCriteria(LoginEntity.class).list();
        if(users.contains(user)){
            HttpSession httpSession = request.getSession();;
            httpSession.setAttribute("user",userName);
//            map.addAttribute("userName",userName);
            return "loginResult";
        }

        return "loginf";
    }

    @RequestMapping(value = "logoff",method = RequestMethod.GET)
    public String logoff(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "logoffResult";
    }


    @RequestMapping(value = "/announce/{aid}",method = RequestMethod.GET)
    public String announce(ModelMap map, @PathVariable("aid") String aid){
        System.out.printf(aid);
        conn conn = new conn();
        Session session = conn.getSession();

        Criteria announcebodycriterion = session.createCriteria(AnnouncesEntity.class);
        announcebodycriterion.add(Restrictions.like("aid",Integer.parseInt(aid)));
        AnnouncesEntity announce =(AnnouncesEntity)announcebodycriterion.list().get(0);


        Criteria replycriterion = session.createCriteria(ReplyEntity.class);
        replycriterion.add(Restrictions.like("aid",Integer.parseInt(aid)));
        List<ReplyEntity> reply = replycriterion.list();

        map.addAttribute("announce",announce);
        map.addAttribute("reply",reply);
        return "announce";
    }

    @RequestMapping(value = "sendAnnocune",method = RequestMethod.POST)
    public String sendAnnounce(HttpSession httpSession,ModelMap map,@RequestParam String topic,@RequestParam String announceBody){

        String userName = (String)httpSession.getAttribute("user");
        if(userName!=null){
            AnnouncesEntity announce = new AnnouncesEntity();
            announce.setTopic(topic);
            announce.setAnnouncesBody(announceBody);
//            announce.setAid(Integer.parseInt(Aid));
            announce.setUserName(userName);
            announce.setAnnouncesClass(1);
            announce.setAnnouncesState(1);

            conn conn = new conn();
            Session session = conn.getSession();
            Transaction ts = session.getTransaction();
            try {
                ts.begin();
                session.save(announce);
                ts.commit();
            }
            catch (Exception e){
                e.printStackTrace();
                ts.rollback();
            }finally {
                session.close();
            }
            return "indexRefresh";
        }
        else {
            return "login";
        }
    }

    @RequestMapping(value = "announce/sendReply",method = RequestMethod.POST)
    public String sendReply(HttpSession httpSession,@RequestParam String replyBody,@RequestParam int Aid){
        String userName = (String)httpSession.getAttribute("user");
        if(userName!=null){
            ReplyEntity reply = new ReplyEntity();
            reply.setUserName(userName);
            reply.setAid(Aid);
            reply.setReplyBody(replyBody);

            conn conn = new conn();
            Session session = conn.getSession();
            Transaction ts = session.getTransaction();
            try {
                ts.begin();
                session.save(reply);
                ts.commit();
            }
            catch (Exception e){
                e.printStackTrace();
                ts.rollback();
            }finally {
             session.close();
            }
            return "index";
        }
        else {
            return "login";
        }


    }

    public static void main(String[] args) {

    }
}
