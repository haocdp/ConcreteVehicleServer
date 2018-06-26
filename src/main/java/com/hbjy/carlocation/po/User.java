package com.hbjy.carlocation.po;

import javax.persistence.*;

/**
 * Created by haoc_dp on 16/8/4.
 */
@Entity
@Table(name = "user")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @Column(name="username",nullable = false)
   private String username;

   @Column(name="password",nullable = false)
   private String password;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof User)) return false;

      User user = (User) o;

      if (getId() != user.getId()) return false;
      if (!getUsername().equals(user.getUsername())) return false;
      return getPassword().equals(user.getPassword());

   }

   @Override
   public int hashCode() {
      int result = getId();
      result = 31 * result + getUsername().hashCode();
      result = 31 * result + getPassword().hashCode();
      return result;
   }
}
