package com.acat.controller;

import com.acat.entity.RegisterEntity;
import com.acat.entity.UserInfoEntity;
import com.acat.service.UserInfoService;
import com.acat.vo.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/userInfo")
@SuppressWarnings("all")
@Api(value = "userInfo表",tags = {"搭建userInfo表的所有接口"})
public class UserInfoController {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService userInfoService;

    UserInfoEntity userInfoEntity = new UserInfoEntity();

    Integer bishe_user_info_register_id = null;

    @PostMapping("/addUserInfo")
    @ApiOperation(value = "完善用户信息普通字段接口",notes = "完善用户信息普通字段接口")
    @ApiImplicitParam(value = "userInfo的vo层",name = "userInfo的vo层")
    public void addUserInfo(@RequestBody UserInfoVo userInfoVo, HttpSession session){

//        RegisterEntity registerEntity = (RegisterEntity)session.getAttribute("registerEntity");

        System.out.println("********");
        System.out.println(userInfoVo);
        System.out.println("********");

        bishe_user_info_register_id = userInfoVo.getBishe_register_id();

        userInfoEntity.setBishe_user_info_nike(userInfoVo.getBishe_user_info_nike());
        userInfoEntity.setBishe_user_info_sex(userInfoVo.getBishe_user_info_sex());
        userInfoEntity.setBishe_user_info_email(userInfoVo.getBishe_user_info_email());
        userInfoEntity.setBishe_user_info_register_id(bishe_user_info_register_id);
    }

    @PostMapping("/addUserInfoImage")
    @ApiOperation(value = "完善用户信息图片接口",notes = "完善用户信息图片接口")
    @ApiImplicitParam(value = "MultipartFile file",name = "MultipartFile file")
    public String addUserInfoImage(@RequestParam("file") MultipartFile file, HttpSession session){

        String path = session.getServletContext().getRealPath("/");
        System.out.println(path);

        String fileName = file.getOriginalFilename();
        System.out.println(fileName);

        File targetFile = new File(path+fileName);
        System.out.println("************"+targetFile.getAbsolutePath()+"************");

        String zuizhongName = targetFile.getAbsolutePath();

        try{
            file.transferTo(targetFile);
        }catch (IOException e){
            e.printStackTrace();
        }

        userInfoEntity.setBishe_user_info_image(zuizhongName);
        System.out.println(userInfoEntity);
        System.out.println("-----------------------------");
        userInfoService.addUserInfo(userInfoEntity);

        String ImagePathName = userInfoService.getImagePath(bishe_user_info_register_id);
        System.out.println("&&&&&&"+ImagePathName+"&&&&&&&&&&");

        return ImagePathName;
    }

    @PostMapping("/updateUserInfo")
    @ApiOperation(value = "修改用户信息普通字段接口",notes = "修改用户信息普通字段接口")
    @ApiImplicitParam(value = "userInfo的vo层",name = "userInfo的vo层")
    public void updateUserInfo(@RequestBody UserInfoVo userInfoVo, HttpSession session){

        RegisterEntity registerEntity = (RegisterEntity)session.getAttribute("registerEntity");

        userInfoEntity.setBishe_user_info_nike(userInfoVo.getBishe_user_info_nike());
        userInfoEntity.setBishe_user_info_sex(userInfoVo.getBishe_user_info_sex());
        userInfoEntity.setBishe_user_info_email(userInfoVo.getBishe_user_info_email());
        userInfoEntity.setBishe_user_info_register_id(registerEntity.getBishe_register_id());
    }

    @PostMapping("/updateUserInfoImage")
    @ApiOperation(value = "修改用户信息图片接口",notes = "修改用户信息图片接口")
    @ApiImplicitParam(value = "MultipartFile file",name = "MultipartFile file")
    public void updateUserInfoImage(MultipartFile file, HttpSession session){
        String path = session.getServletContext().getRealPath("/UserInfoImage");
        System.out.println(path);

        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        File targetFile = new File(path,fileName);
//        if(!targetFile.exists()){
//            targetFile.mkdirs();
//        }

        try{
            file.transferTo(targetFile);
        }catch (IOException e){
            e.printStackTrace();
        }

        userInfoEntity.setBishe_user_info_image(fileName);
        System.out.println(userInfoEntity);
        System.out.println("-----------------------------");
        userInfoService.updateUserInfo(userInfoEntity);
    }

    @GetMapping("/getUserInfo")
    @ApiOperation(value = "获取用户信息接口",notes = "获取用户信息接口")
    public UserInfoEntity getUserInfo(HttpSession session){

        UserInfoEntity userInfoEntity = null;

        RegisterEntity registerEntity = (RegisterEntity) session.getAttribute("RegisterEntity");

        System.out.println("RegisterEntity:================"+registerEntity);

        Integer bishe_userInfo_register_id = registerEntity.getBishe_register_id();
        Integer bishe_userInfo_id = userInfoService.getUserInfoIdByRegisterId(bishe_userInfo_register_id);
        if(bishe_userInfo_id != null){
            userInfoEntity = userInfoService.getUserInfoById(bishe_userInfo_id);
        }
        return userInfoEntity;
    }

    @GetMapping("/getList")
    @ApiOperation(value = "获取全部成员信息",notes = "获取全部成员信息")
    public List<UserInfoEntity> getList(){
        List<UserInfoEntity> list = userInfoService.getList();
        return list;
    }

    @GetMapping("/deleteUserInfo/{bishe_user_info_id}")
    @ApiOperation(value = "删除用户信息接口",notes = "删除用户信息接口")
    @ApiImplicitParam(value = "bishe_user_info_id",name = "bishe_user_info_id")
    public String deleteUserInfo(@PathVariable("bishe_user_info_id") Integer bishe_user_info_id){
        userInfoService.deleteUserInfo(bishe_user_info_id);
        return "1";//删除成功
    }
}
