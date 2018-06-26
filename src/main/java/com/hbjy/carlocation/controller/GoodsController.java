package com.hbjy.carlocation.controller;

import com.hbjy.carlocation.exception.BizException;
import com.hbjy.carlocation.service.GoodsService;
import com.hbjy.carlocation.vo.GoodsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hao on 2016/8/6.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    private static Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @ResponseBody
    @RequestMapping(value = "/listGoods",method = RequestMethod.GET)
    public Object listGoodsByPage(
            @RequestParam(value = "page",defaultValue = "1")int page,
            @RequestParam(value = "number",defaultValue = "10")int number
    )throws BizException{
        logger.info(String.format("list goods by page parameter：page=%d,number=%d",page,number));
        try{
            List<GoodsVO> goodsVOList = goodsService.getGoodsByPage(page, number);
            if (goodsVOList == null){
                goodsVOList = new ArrayList<>();
            }

            logger.info("list goods successfully");
            return goodsVOList;
        }catch (BizException e){
            logger.info("failed to list goods " + e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.info("failed to list goods " + e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
