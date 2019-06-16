package com.acat.controller;

import com.acat.entity.ComplainEntity;
import com.acat.service.ComplainService;
import com.acat.vo.CommentVo;
import com.acat.vo.ComplainVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/complain")
@Api(value = "complain表",tags = {"搭建complain表的所有接口"})
public class ComplainController {

    private static final Logger logger = LoggerFactory.getLogger(ComplainController.class);

    @Autowired
    private ComplainService complainService;

    @PostMapping("/addComplain")
    @ApiOperation(value = "添加匿名投诉",notes = "添加匿名投诉")
    @ApiImplicitParam(value = "complain的vo层",name = "complain的vo层")
    public String addComplain(@RequestBody ComplainVo complainVo){

        System.out.println("^^^^^^^^^^^^^");
        System.out.println(complainVo);
        System.out.println("^^^^^^^^^^^^^");

        ComplainEntity complainEntity = new ComplainEntity();
        complainEntity.setBishe_complain_content(complainVo.getBishe_complain_content());
        complainService.addComplain(complainEntity);

        return "1";//投诉成功

    }
}
