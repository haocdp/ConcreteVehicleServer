package com.hbjy.carlocation.service;

import com.hbjy.carlocation.exception.BizException;
import com.hbjy.carlocation.vo.PositionVO;

import java.util.List;

/**
 * Created by hao on 2016/8/6.
 */
public interface PositionService {

    /**
     * 根据物品id获取对应的位置信息
     * @param goodsId 物品id
     * @return 位置列表
     * @throws BizException
     */
    List<PositionVO> getPositionByGoods(int goodsId) throws BizException;
}
