package com.hbjy.carlocation.service;

import com.hbjy.carlocation.dao.PlansTransportDao;
import com.hbjy.carlocation.exception.BizException;
import com.hbjy.carlocation.po.PlansTransport;
import com.hbjy.carlocation.vo.PlansTransportVO;
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
public class PlansTransportServiceImpl implements PlansTransportService{

    private static Logger logger = LoggerFactory.getLogger(PlansTransportServiceImpl.class);

    @Autowired
    private PlansTransportDao plansTransportDao;
    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Override
    public List<PlansTransportVO> getPlansTransportByPageAndStatus(int page, int number , PlansTransport.Status status) throws BizException {
        if(page < 1)
            throw new BizException(BizException.ERROR_CODE_PARAMETER_WRONG,"页数参数错误");
        if(number < 1)
            throw new BizException(BizException.ERROR_CODE_PARAMETER_WRONG,"页面条数参数错误");
        logger.info(String.format("list plansTransport by page parameter:page=%d,number=%d",page,number));

        List<PlansTransportVO> plansTransportVOList = null;
        try {
            Page<PlansTransport> pageable = plansTransportDao.findByStatus(status,new PageRequest(page-1, number));

            if (pageable.getTotalElements() != 0) {
                plansTransportVOList = new ArrayList<>();
                PlansTransportVO plansTransportVO = null;
                for(PlansTransport plansTransport : pageable.getContent()) {
                    plansTransportVO = new PlansTransportVO();
                    dozerBeanMapper.map(plansTransport, plansTransportVO);

                    plansTransportVO.setUserId(plansTransport.getUser().getId());
                    plansTransportVO.setGoodsId(plansTransport.getGoods().getId());
                    plansTransportVO.setGoods(plansTransport.getGoods().getName());
                    plansTransportVO.setStatus(plansTransport.getStatus() == PlansTransport.Status.INPROGRESS ?
                            "正在进行" : "已经完成");

                    plansTransportVOList.add(plansTransportVO);
                }
            }

            logger.info("list plansTransport by page successfully");
        }catch(Exception e){
            logger.info("failed to list planTransport" + e.getMessage());
            throw e;
        }

        return plansTransportVOList;
    }

    @Override
    public List<PlansTransportVO> getPlansTransportByPage(int page, int number) throws BizException {
        if(page < 1)
            throw new BizException(BizException.ERROR_CODE_PARAMETER_WRONG,"页数参数错误");
        if(number < 1)
            throw new BizException(BizException.ERROR_CODE_PARAMETER_WRONG,"页面条数参数错误");
        logger.info(String.format("list plansTransport by page parameter:page=%d,number=%d",page,number));

        List<PlansTransportVO> plansTransportVOList = null;
        try {
            Page<PlansTransport> pageable = plansTransportDao.findAll(new PageRequest(page - 1, number));

            if (pageable.getTotalElements() != 0) {
                plansTransportVOList = new ArrayList<>();
                PlansTransportVO plansTransportVO = null;
                for(PlansTransport plansTransport : pageable.getContent()) {
                    plansTransportVO = new PlansTransportVO();
                    dozerBeanMapper.map(plansTransport, plansTransportVO);

                    plansTransportVO.setUserId(plansTransport.getUser().getId());
                    plansTransportVO.setGoodsId(plansTransport.getGoods().getId());
                    plansTransportVO.setGoods(plansTransport.getGoods().getName());
                    plansTransportVO.setStatus(plansTransport.getStatus() == PlansTransport.Status.INPROGRESS ?
                            "正在进行" : "已经完成");

                    plansTransportVOList.add(plansTransportVO);
                }
            }

            logger.info("list plansTransport by page successfully");
        }catch(Exception e){
            logger.info("failed to list planTransport" + e.getMessage());
            throw e;
        }

        return plansTransportVOList;
    }


    @Override
    public PlansTransportVO getPlansTransportById(int id) throws BizException{
        if(id < 1)
            throw new BizException(BizException.ERROR_CODE_PARAMETER_WRONG,"任务单id参数错误");
        logger.info(String.format("get plansTransport by id=%d",id));

        try {
            PlansTransport plansTransport = plansTransportDao.findOne(id);

            if (plansTransport == null)
                throw new BizException(BizException.ERROR_CODE_PLAN_NOT_FOUND, "任务单未找到");

            PlansTransportVO plansTransportVO = new PlansTransportVO();
            dozerBeanMapper.map(plansTransport, plansTransportVO);

            plansTransportVO.setUserId(plansTransport.getUser().getId());
            plansTransportVO.setGoodsId(plansTransport.getGoods().getId());
            plansTransportVO.setGoods(plansTransport.getGoods().getName());
            plansTransportVO.setStatus(plansTransport.getStatus() == PlansTransport.Status.INPROGRESS ?
                "正在进行":"已经完成");

            logger.info("get plansTransport successfully");

            return plansTransportVO;
        }catch(Exception e){
            logger.info("failed to get plansTransport" + e.getMessage());
            throw e;
        }
    }
}
