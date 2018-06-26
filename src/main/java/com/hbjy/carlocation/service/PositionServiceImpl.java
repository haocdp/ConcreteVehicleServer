package com.hbjy.carlocation.service;

import com.hbjy.carlocation.dao.PositionDao;
import com.hbjy.carlocation.exception.BizException;
import com.hbjy.carlocation.po.Position;
import com.hbjy.carlocation.vo.PositionVO;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hao on 2016/8/6.
 */
public class PositionServiceImpl implements PositionService{

    private static Logger logger = LoggerFactory.getLogger(PositionServiceImpl.class);

    @Autowired
    private PositionDao positionDao;
    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Override
    public List<PositionVO> getPositionByGoods(int goodsId) throws BizException {
        if(goodsId < 1)
            throw new BizException(BizException.ERROR_CODE_PARAMETER_WRONG,"物品id错误");
        logger.info(String.format("list position by goodsId=%d",goodsId));

        try {
            List<PositionVO> positionVOList = null;
            List<Position> list = positionDao.findByGoodsId(goodsId);

            PositionVO positionVO = null;
            if(list != null && list.size() != 0){
                positionVOList = new ArrayList<>();
                for(Position position : list) {
                    positionVO = new PositionVO();
                    dozerBeanMapper.map(position, positionVO);
                    positionVOList.add(positionVO);
                }
            }
            logger.info("list position successfully");
            return positionVOList;
        }catch (Exception e){
            logger.info("failed to list position" + e.getMessage());
        }

        return null;
    }
}
