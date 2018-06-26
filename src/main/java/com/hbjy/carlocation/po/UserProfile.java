package com.hbjy.carlocation.po;

import javax.persistence.*;
import java.sql.Blob;

/**
 * Created by hao on 2016/8/8.
 */
@Entity
@Table(name="user_profile")
public class UserProfile {

    public enum Gender{
        MALE,FEMALE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nickName",nullable = false,length = 30)
    private String nickName;

    @Column(name = "gender",nullable = false)
    private Gender gender;

    @Column(name = "birthday",nullable = false,length = 20)
    private String birthday;

    @Column(name = "introduction",nullable = false)
    private String introduction;

    @OneToOne(targetEntity = User.class)
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserProfile)) return false;

        UserProfile that = (UserProfile) o;

        if (id != that.id) return false;
        if (!nickName.equals(that.nickName)) return false;
        if (gender != that.gender) return false;
        if (!birthday.equals(that.birthday)) return false;
        if (!introduction.equals(that.introduction)) return false;
        return user.equals(that.user);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nickName.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + introduction.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }
}
