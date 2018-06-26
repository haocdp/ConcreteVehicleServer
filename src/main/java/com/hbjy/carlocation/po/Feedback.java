package com.hbjy.carlocation.po;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hao on 2016/8/8.
 */
@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "content",nullable = false,length = 600)
    private String content;

    @Column(name = "createTime",nullable = false)
    private Date createTime;

    @ManyToOne(targetEntity = User.class)
    private User user;

    public Feedback(){}

    public Feedback(String content, Date createTime, User user){
        this.content = content;
        this.createTime = createTime;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feedback)) return false;

        Feedback feedback = (Feedback) o;

        if (id != feedback.id) return false;
        if (!content.equals(feedback.content)) return false;
        if (!createTime.equals(feedback.createTime)) return false;
        return user.equals(feedback.user);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + content.hashCode();
        result = 31 * result + createTime.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }
}
