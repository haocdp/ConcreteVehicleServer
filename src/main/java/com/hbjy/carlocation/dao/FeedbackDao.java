package com.hbjy.carlocation.dao;

import com.hbjy.carlocation.po.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hao on 2016/8/8.
 */
@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer>{

}
