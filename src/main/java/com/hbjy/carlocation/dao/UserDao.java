package com.hbjy.carlocation.dao;

/**
 * Created by hao on 2016/8/5.
 */

import com.hbjy.carlocation.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
}
