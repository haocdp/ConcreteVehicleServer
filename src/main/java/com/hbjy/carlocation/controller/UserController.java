package com.hbjy.carlocation.controller;

import com.hbjy.carlocation.exception.BizException;
import com.hbjy.carlocation.service.UserService;
import com.hbjy.carlocation.vo.UserProfileVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hao on 2016/8/8.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addFeedback",method = RequestMethod.POST)
    public ResponseEntity<String> addFeedback(
            @RequestParam(value = "content",required = true)String content,
            @RequestParam(value = "userId",required = false,defaultValue = "1")int userId
    ){

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "text/plain;charset=utf-8;");

        logger.info("add feedback content={},user_id={}",content,userId);

        try {
            userService.addFeedback(content, userId);
            return new ResponseEntity<String>("反馈成功",responseHeaders,HttpStatus.OK);
      }catch (BizException e){
            logger.info("failed to add feedback " + e.getMessage());
            return new ResponseEntity<String>(e.getMessage(),responseHeaders,HttpStatus.OK);
        }catch (Exception e){
            logger.info("failed to add feedback " + e.getMessage());
            return new ResponseEntity<String>(e.getMessage(),responseHeaders,HttpStatus.OK);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getUserProfile",method = RequestMethod.GET)
    public Object getUserProfile(
            @RequestParam(value = "userId",required = false,defaultValue = "1")int userId
    ){
        logger.info("get userProfile user_id= {}", userId);

        try {
            UserProfileVO userProfileVO = userService.getUserProfile(userId);
            return userProfileVO;
        }catch (BizException e){
            logger.info("failed to get userProfile " + e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.info("failed to get userProfile " + e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
