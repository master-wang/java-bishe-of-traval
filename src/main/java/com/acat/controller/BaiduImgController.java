package com.acat.controller;

import com.acat.entity.BaiduImgEntity;
import com.acat.service.BaiduImgService;
import com.acat.util.FileUtil;
import com.baidu.aip.ocr.AipOcr;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/baiduImg")
@SuppressWarnings("all")
@Api(value = "baiduocr表",tags = {"搭建baiduocr表的所有接口"})
public class BaiduImgController {

    @Autowired
    private BaiduImgService baiduImgService;

    @ApiOperation(value = "添加百度ocr图片识别需要的图片",notes = "添加百度ocr图片识别需要的图片")
    @ApiImplicitParam(value = "file",name = "file")
    @PostMapping("/getBaiduImg")
    public String addBaiduImg(MultipartFile file,HttpSession session){

        BaiduImgEntity baiduImgEntity = new BaiduImgEntity();

        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static" + "/upload/";

        String filename = UUID.randomUUID() + file.getOriginalFilename();

        System.out.println(filename);

        try{
            // 该方法是对文件写入的封装，在util类中，导入该包即可使用，后面会给出方法
            FileUtil.fileupload(file.getBytes(), path, filename);
        }catch (IOException e){
            e.printStackTrace();
        }

        //tour.setBishe_tour_image("http://localhost:8080/" + "upload/" + filename);
        baiduImgEntity.setBishe_baiduimg_image("http://localhost:8080/" + "upload/" + filename);

        System.out.println("-----------------------------");
        System.out.println(baiduImgEntity);
        System.out.println("-----------------------------");

        baiduImgService.addBaiduImg(baiduImgEntity);

        return baiduImgEntity.getBishe_baiduimg_image();//上传成功
    }

}
