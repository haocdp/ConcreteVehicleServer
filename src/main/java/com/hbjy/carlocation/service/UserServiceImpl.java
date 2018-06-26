package com.hbjy.carlocation.service;

import com.hbjy.carlocation.dao.FeedbackDao;
import com.hbjy.carlocation.dao.UserDao;
import com.hbjy.carlocation.dao.UserProfileDao;
import com.hbjy.carlocation.exception.BizException;
import com.hbjy.carlocation.po.Feedback;
import com.hbjy.carlocation.po.User;
import com.hbjy.carlocation.po.UserProfile;
import com.hbjy.carlocation.vo.UserProfileVO;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by hao on 2016/8/8.
 */
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FeedbackDao feedbackDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserProfileDao userProfileDao;
    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Override
    public void addFeedback(String content, int userId) throws BizException {
        if("".equals(content) || content == null)
            throw new BizException(BizException.ERROR_CODE_PARAMETER_WRONG,"反馈内容为空");
        if(userId < 1)
            throw new BizException(BizException.ERROR_CODE_PARAMETER_WRONG,"用户不存在");
        logger.info("add feedback user= {}",userId);
        try{
            User user = userDao.findOne(userId);
            if(user == null)
                throw new BizException(BizException.ERROR_CODE_USER_NOT_FOUND,"用户不存在");
            Feedback feedback = new Feedback(content, new Date(), user);
            feedbackDao.save(feedback);
            logger.info("add feedback successfully");
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public UserProfileVO getUserProfile(int userId) throws BizException {
        if(userId < 0)
            throw new BizException(BizException.ERROR_CODE_PARAMETER_WRONG,"用户不存在");
        logger.info("get userProfile user_id= {}",userId);

        try{
            User user = userDao.findOne(userId);
            if (user == null)
                throw new BizException(BizException.ERROR_CODE_USER_NOT_FOUND,"用户不存在");

            UserProfile userProfile = userProfileDao.findByUser(user);
            if(userProfile == null)
                throw new BizException(BizException.ERROR_CODE_USER_PROFILE_NOT_FOUND,"用户资料不存在");
            UserProfileVO userProfileVO = new UserProfileVO();
            dozerBeanMapper.map(userProfile, userProfileVO);

            userProfileVO.setGender(userProfile.getGender() == UserProfile.Gender.FEMALE ? "男" : "女");

            logger.info("get userProfile successfully");
            return userProfileVO;
        }catch(Exception e){
            throw e;
        }
    }
}
