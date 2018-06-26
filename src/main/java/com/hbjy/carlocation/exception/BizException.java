package com.hbjy.carlocation.exception;

/**
 * Created by hao on 2016/8/6.
 */
public class BizException extends Exception {
    /**用户不存在*/
    public final static Integer ERROR_CODE_USER_NOT_FOUND = new Integer(2000);
    /**物品不存在*/
    public final static Integer ERROR_CODE_GOODS_NOT_FOUND = new Integer(2001);
    /**参数为空*/
    public final static Integer ERROR_CODE_PARAMETER__MISS = new Integer(2002);
    /**参数格式错误*/
    public final static Integer ERROR_CODE_PARAMETER_WRONG = new Integer(2003);
    /**任务单不存在*/
    public final static Integer ERROR_CODE_PLAN_NOT_FOUND = new Integer(2004);
    /**用户资料不存在*/
    public final static Integer ERROR_CODE_USER_PROFILE_NOT_FOUND = new Integer(2005);

    private Integer errorCode;

    public BizException(Integer errorCode, String msg){
        super(msg);
        this.errorCode = errorCode;
    }

    public BizException(Integer errorCode, String msg, Throwable e){
        super(msg, e);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode(){
        return this.errorCode;
    }
}
