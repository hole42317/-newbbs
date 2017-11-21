package com.lui.controller;

import com.lui.db.announces.AnnouncesEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lui on 2017/11/21.
 */
@Controller
public class MainPage {

    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    public String mp(ModelMap map){
        conn conn = new conn();
        Session session = conn.getSession();
        List<AnnouncesEntity> announces = session.createCriteria(AnnouncesEntity.class).list();
        System.out.printf(announces.get(1).toString());

        map.addAttribute("announces",announces);
        return "index";
    }

    public static void main(String[] args) {
//        new MainPage().mp();
    }
}
