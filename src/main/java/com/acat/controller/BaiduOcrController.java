package com.acat.controller;

import com.acat.entity.ComplainEntity;
import com.acat.service.BaiduOcrService;
import com.acat.service.ComplainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/baiduOcr")
@Api(value = "baiduOcr",tags = {"通过第三方百度ocr接口获取图片文字的信息"})
public class BaiduOcrController {

    @Autowired
    private BaiduOcrService baiduOcrService;

    @Autowired
    private ComplainService complainService;


    @ApiOperation(value = "通过第三方百度ocr接口获取图片文字的接口",notes = "通过第三方百度ocr接口获取图片文字的接口")
    @ApiImplicitParam(value = "picUrl",name = "picUrl")
    @GetMapping("/getBaiduOcr")
    public String getBaiduOcr(String picUrl){

        System.out.println("picUrl是:"+picUrl);


        ComplainEntity complainEntity = new ComplainEntity();

        complainEntity.setBishe_complain_content(baiduOcrService.getBaiduOcr(picUrl));

        complainService.addComplain(complainEntity);

        return "1";
    }

}
