package com.lui.db.announces;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lui on 2017/11/21.
 */
@Entity
@Table(name = "announces", schema = "BBS", catalog = "")
public class AnnouncesEntity {
    private int aid;
    private String userName;
    private String topic;
    private String announcesBody;
    private Serializable announcesTime;
    private int announcesState;
    private int announcesClass;

    @Id
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
    @Column(name = "topic", nullable = false, length = 30)
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Basic
    @Column(name = "announcesBody", nullable = false, length = 400)
    public String getAnnouncesBody() {
        return announcesBody;
    }

    public void setAnnouncesBody(String announcesBody) {
        this.announcesBody = announcesBody;
    }

//    @Basic
//    @Column(name = "announcesTime", nullable = true)
//    public Serializable getAnnouncesTime() {
//        return announcesTime;
//    }

    public void setAnnouncesTime(Serializable announcesTime) {
        this.announcesTime = announcesTime;
    }

    @Basic
    @Column(name = "announcesState", nullable = false)
    public int getAnnouncesState() {
        return announcesState;
    }

    public void setAnnouncesState(int announcesState) {
        this.announcesState = announcesState;
    }

    @Basic
    @Column(name = "announcesClass", nullable = false)
    public int getAnnouncesClass() {
        return announcesClass;
    }

    public void setAnnouncesClass(int announcesClass) {
        this.announcesClass = announcesClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnnouncesEntity that = (AnnouncesEntity) o;

        if (aid != that.aid) return false;
        if (announcesState != that.announcesState) return false;
        if (announcesClass != that.announcesClass) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (topic != null ? !topic.equals(that.topic) : that.topic != null) return false;
        if (announcesBody != null ? !announcesBody.equals(that.announcesBody) : that.announcesBody != null)
            return false;
        if (announcesTime != null ? !announcesTime.equals(that.announcesTime) : that.announcesTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aid;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (announcesBody != null ? announcesBody.hashCode() : 0);
        result = 31 * result + (announcesTime != null ? announcesTime.hashCode() : 0);
        result = 31 * result + announcesState;
        result = 31 * result + announcesClass;
        return result;
    }
}
