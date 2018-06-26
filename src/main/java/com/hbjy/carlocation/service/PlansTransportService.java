package com.hbjy.carlocation.service;

import com.hbjy.carlocation.exception.BizException;
import com.hbjy.carlocation.po.PlansTransport;
import com.hbjy.carlocation.vo.PlansTransportVO;

import java.util.List;

/**
 * Created by hao on 2016/8/6.
 */
public interface PlansTransportService {
    /**
     * 根据分页参数和状态获取分页数据
     * @param page 页数
     * @param number 每页数据条数
     * @param status 要查悉的任务状态
     * @return 任务列表
     * @throws BizException
     */
    List<PlansTransportVO> getPlansTransportByPageAndStatus(int page, int number, PlansTransport.Status status)throws BizException;

    /**
     * 根据分页参数获取分页数据
     * @param page 页数
     * @param number 每页数据条数
     * @return 任务列表
     * @throws BizException
     */
    List<PlansTransportVO> getPlansTransportByPage(int page, int number)throws BizException;

    /**
     * 根据id获取任务数据
     * @param id 任务id
     * @return PlansTransport
     */
    PlansTransportVO getPlansTransportById(int id)throws BizException;
}
