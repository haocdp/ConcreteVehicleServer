package com.hbjy.carlocation.service;

import com.hbjy.carlocation.dao.GoodsDao;
import com.hbjy.carlocation.dao.PositionDao;
import com.hbjy.carlocation.exception.BizException;
import com.hbjy.carlocation.po.Goods;
import com.hbjy.carlocation.po.Position;
import com.hbjy.carlocation.vo.GoodsVO;
import com.hbjy.carlocation.vo.PositionVO;
import org.dozer.BeanFactory;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hao on 2016/8/6.
 */
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private PositionDao positionDao;

    private static Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);
    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Override
    public List<GoodsVO> getGoodsByPage(int page, int number) throws BizException {
        if(page < 1)
            throw new BizException(BizException.ERROR_CODE_PARAMETER_WRONG,"页数参数错误");
        if(number < 1)
            throw new BizException(BizException.ERROR_CODE_PARAMETER_WRONG,"页面条数参数错误");
        logger.info(String.format("list goods by page parameter:page=%d,number=%d",page,number));
        List<GoodsVO> goodsVOList = null;

        try {
            Page<Goods> pageable = goodsDao.findAll(new PageRequest(page-1, number));

            /**
             * 数据库中存在物品信息
             */
            if (pageable.getTotalElements() != 0) {
                GoodsVO goodsVO = null;
                goodsVOList = new ArrayList<>();
                List<Position> positionList = null;

                for (Goods goods : pageable.getContent()) {
                    goodsVO = new GoodsVO();
                    dozerBeanMapper.map(goods, goodsVO);

                    /**
                     * 查找物品对应的轨迹信息
                     */
                    positionList = positionDao.findByGoodsId(goods.getId());
                    if (positionList != null){
                        PositionVO positionVO = null;
                        for(Position position : positionList){
                            positionVO = new PositionVO();
                            dozerBeanMapper.map(position, positionVO);
                            goodsVO.getPositionVOList().add(positionVO);
                        }
                    }

                    goodsVO.setUserId(goods.getUser().getId());
                    goodsVOList.add(goodsVO);

                }

            }
            logger.info("list goods by page parameter successfully");
        }catch (Exception e){
            logger.info("failed to list goods"+e.getMessage());
            throw e;
        }

        return goodsVOList;
    }
}
