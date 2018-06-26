package com.hbjy.carlocation.dao;

import com.hbjy.carlocation.po.User;
import com.hbjy.carlocation.po.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hao on 2016/8/8.
 */
@Repository
public interface UserProfileDao extends JpaRepository<UserProfile,Integer>{
    UserProfile findByUser(User user);
}
