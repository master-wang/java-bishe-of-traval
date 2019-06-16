package com.acat.controller;

import com.acat.entity.LunboImgEntity;
import com.acat.service.LunboService;
import com.acat.util.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/lunboImg")
@SuppressWarnings("all")
@Api(value = "file",tags = {"搭建轮播图的信息"})
public class LunboImgController {


    @Autowired
    private LunboService lunboService;

    @PostMapping("/addLunboImg")
    @ApiOperation(value = "添加轮播图的接口",notes = "添加轮播图的接口")
    @ApiImplicitParam(value = "file",name = "file")
    public String addLunboImg(MultipartFile[] file, HttpSession session){

        System.out.println("$$$$$$$$$$$$$$$$$");
        lunboService.deleteAllLunboImg();
        System.out.println("$$$$$$$$$$$$$$$$$");

        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static" + "/lunboUpload/";

        for(int i=0;i<file.length;i++){

            LunboImgEntity lunboImgEntity = new LunboImgEntity();

            String filename = UUID.randomUUID() + file[i].getOriginalFilename();

            System.out.println(filename);

            try{
                FileUtil.fileupload(file[i].getBytes(), path, filename);
                lunboImgEntity.setBishe_lunboimg_image("http://localhost:8080/" + "lunboUpload/" + filename);

                lunboService.addLunboImg(lunboImgEntity);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return "1";//上传成功
    }

    @GetMapping("/getLunboImg")
    @ApiOperation(value = "获取轮播图的接口",notes = "获取轮播图的接口")
    public List<LunboImgEntity> getLunboImg(){
        List<LunboImgEntity> list = lunboService.getLunboImg();
        return list;
    }
}
/**
 * 1.register表(id,yonghuming,mima)
 * 2.artcile表(id,title,content,biaoqian,hitcount,register_id)
 * 3.biaoqian表(id,neirong)
 * 4.comment表(id,neirong,register_id,article_id)
 * 5.tupian表(id,picUrl,neirong,register_id)
 * 6.collect表(id,register_id,article_id)
 * 7.liulan表(id,register_id,article_id)
 */
