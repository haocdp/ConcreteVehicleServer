package com.hbjy.carlocation.controller;

import com.hbjy.carlocation.exception.BizException;
import com.hbjy.carlocation.po.PlansTransport;
import com.hbjy.carlocation.service.PlansTransportService;
import com.hbjy.carlocation.vo.PlansTransportVO;
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
@RequestMapping("/plansTransport")
public class PlansTransportController {

    @Autowired
    private PlansTransportService plansTransportService;
    private static Logger logger = LoggerFactory.getLogger(PlansTransportController.class);

    @ResponseBody
    @RequestMapping(value = "/listPlansTransport",method = RequestMethod.GET)
    public Object getPlansTransportByPage(
            @RequestParam(value = "page",defaultValue = "1")int page,
            @RequestParam(value = "number",defaultValue = "10")int number,
            @RequestParam(value = "status",required = false, defaultValue = "0")int status
    )throws BizException{
        logger.info(String.format("list plansTransport by page parameter:page=%d,number=%d",page,number));

        try{
            List<PlansTransportVO> plansTransportVOList;

            if(status == 0)
                plansTransportVOList = plansTransportService.getPlansTransportByPage(page,number);
            else if(status == 1){
                plansTransportVOList = plansTransportService.getPlansTransportByPageAndStatus(page, number,
                        PlansTransport.Status.INPROGRESS);
            }else if(status == 2){
                plansTransportVOList = plansTransportService.getPlansTransportByPageAndStatus(page, number,
                        PlansTransport.Status.COMPLETED);
            }else{
                throw new BizException(BizException.ERROR_CODE_PARAMETER_WRONG,"状态数据错误");
            }

            if(plansTransportVOList == null){
                plansTransportVOList = new ArrayList<>();
            }

            logger.info("list plansTransport successfully");
            return plansTransportVOList;
        }catch (BizException e){
            logger.info("failed to list plansTransport " + e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.info("failed to list plansTransport " + e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
