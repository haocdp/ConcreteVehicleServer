package com.hbjy.carlocation.service;

import com.hbjy.carlocation.exception.BizException;
import com.hbjy.carlocation.po.User;
import com.hbjy.carlocation.vo.UserProfileVO;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by hao on 2016/8/6.
 */
public interface UserService {

    /**
     * 增加反馈意见
     * @param content 反馈内容
     * @param userId 反馈用户ID
     * @throws BizException
     */
    void addFeedback(String content,int userId)throws BizException;

    /**
     * 获取用户信息
     * @param userId 对应用户ID
     * @return UserProfileVO
     * @throws BizException
     */
    UserProfileVO getUserProfile(int userId)throws BizException;
}
