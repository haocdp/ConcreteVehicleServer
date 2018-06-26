package com.hbjy.carlocation.service;

import com.hbjy.carlocation.exception.BizException;
import com.hbjy.carlocation.vo.GoodsVO;

import java.util.List;

/**
 * Created by hao on 2016/8/6.
 */
public interface GoodsService {

    /**
     * 根据分页参数获取物品信息
     * @param page 页数
     * @param number 每页数据条数
     * @return 物品列表
     * @throws BizException
     */
    List<GoodsVO> getGoodsByPage(int page, int number)throws BizException;
}
