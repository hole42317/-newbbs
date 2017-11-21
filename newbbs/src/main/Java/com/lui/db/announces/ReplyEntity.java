package com.lui.db.announces;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lui on 2017/11/21.
 */
@Entity
@Table(name = "reply", schema = "BBS", catalog = "")
public class ReplyEntity {
    private int aid;
    private String userName;
    private String replyBody;
    private int replyId;
    private Serializable announcesTime;

    @Basic
    @Column(name = "AID", nullable = false)
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "userName", nullable = false, length = 20)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "replyBody", nullable = false, length = 1000)
    public String getReplyBody() {
        return replyBody;
    }

    public void setReplyBody(String replyBody) {
        this.replyBody = replyBody;
    }

    @Id
    @Column(name = "replyID", nullable = false)
    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReplyEntity that = (ReplyEntity) o;

        if (aid != that.aid) return false;
        if (replyId != that.replyId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (replyBody != null ? !replyBody.equals(that.replyBody) : that.replyBody != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aid;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (replyBody != null ? replyBody.hashCode() : 0);
        result = 31 * result + replyId;
        return result;
    }
}
