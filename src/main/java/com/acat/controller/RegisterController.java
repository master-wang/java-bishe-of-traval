package com.acat.controller;

import com.acat.common.LoginCommon;
import com.acat.entity.RegisterEntity;
import com.acat.service.RegisterService;
import com.acat.util.Md5Util;
import com.acat.vo.LoginVo;
import com.acat.vo.RegisterVo;
import com.acat.vo.UpdatePasswordVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/register")
@Api(value = "register表",tags = {"搭建register表的所有接口"})
public class RegisterController {

    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private RegisterService registerService;

    @ApiOperation(value = "注册接口",notes = "注册接口")
    @ApiImplicitParam(value = "register的vo层",name = "register的vo层")
    @PostMapping(value = "/regis")
    public String register(@RequestBody RegisterVo registerVo){
        System.out.println("-----------");
        System.out.println(registerVo);
        System.out.println("-----------");

        RegisterEntity registerEntity = new RegisterEntity();

        if(registerVo.getBishe_register_username().length()!=0 && registerVo.getBishe_register_password().length()!=0 && registerVo.getBishe_register_repassword().length()!=0) {

            System.out.println("1********************");

            registerEntity.setBishe_register_username(registerVo.getBishe_register_username());

            System.out.println("2********************");

            registerEntity.setBishe_register_password(Md5Util.Encrypt(registerVo.getBishe_register_password()));
        }else{
            return "1";//失败
        }

        System.out.println("3********************");

        registerService.addRegister(registerEntity);
        return "2";//成功
    }

    @ApiOperation(value = "登录接口",notes = "登录接口")
    @ApiImplicitParam(value = "login的vo层",name = "login的vo层")
    @PostMapping(value = "/login")
    public Object login(@RequestBody LoginVo loginVo,HttpSession session){

        LoginCommon loginCommon = new LoginCommon();

        RegisterEntity registerEntity = new RegisterEntity();

        if(loginVo.getBishe_register_username().length()!=0 && loginVo.getBishe_register_password().length()!=0){
            registerEntity = registerService.login(loginVo.getBishe_register_username(),Md5Util.Encrypt(loginVo.getBishe_register_password()));
        }

        if(registerEntity == null){
            System.out.println("账号或密码错误");
            return "1";//账号密码错误
        }

        if(registerEntity.getBishe_register_flag() == 0){

            System.out.println("registerEntity是管理员");
            System.out.println("1--已经存到session里面了");
            session.setAttribute("registerEntity",registerEntity);

            loginCommon.setCode(2);
            loginCommon.setObject(registerEntity);

            return loginCommon;//条砖到管理员页面
        }else{
            System.out.println("registerEntity不是管理员");
            System.out.println("2--已经存到session里面了");
            session.setAttribute("registerEntity",registerEntity);

            loginCommon.setCode(3);
            loginCommon.setObject(registerEntity);

            return loginCommon;//条砖到管理员页面
        }

    }


    @ApiOperation(value = "修改密码接口",notes = "修改密码接口")
    @ApiImplicitParam(value = "UpdatePassword的vo层",name = "UpdatePassword的vo层")
    @PostMapping("/updatePassword")
    public String updatePassword(@RequestBody UpdatePasswordVo updatePasswordVo){

        RegisterEntity registerEntity = registerService.getPassword(updatePasswordVo.getBishe_register_id());

        if(updatePasswordVo.getBishe_register_password()==null || "".equals(updatePasswordVo.getBishe_register_password())){
            return "1";
        }
        if(updatePasswordVo.getBishe_register_newpassword()==null || "".equals(updatePasswordVo.getBishe_register_newpassword())){
            return "2";
        }
        if(updatePasswordVo.getBishe_register_renewpassword()==null || "".equals(updatePasswordVo.getBishe_register_renewpassword())){
            return "3";
        }
        if(!registerEntity.getBishe_register_password().equals(Md5Util.Encrypt(updatePasswordVo.getBishe_register_password()))){
            return "4";
        }
        if (!updatePasswordVo.getBishe_register_newpassword().equals(updatePasswordVo.getBishe_register_renewpassword())) {
            return "5";
        }

        RegisterEntity registerEntity1 = new RegisterEntity();
        registerEntity1.setBishe_register_id(registerEntity.getBishe_register_id());
        registerEntity1.setBishe_register_username(registerEntity.getBishe_register_username());
        registerEntity1.setBishe_register_flag(registerEntity.getBishe_register_flag());
        registerEntity1.setBishe_register_password(Md5Util.Encrypt(updatePasswordVo.getBishe_register_newpassword()));

        registerService.updatePssword(registerEntity1);

        return "6";
    }

    @ApiOperation(value = "安全退出接口",notes = "安全退出接口")
    @GetMapping("/logout")
    public void logout(HttpSession session){
        RegisterEntity registerEntity = (RegisterEntity) session.getAttribute("registerEntity");
        System.out.println("没有从session中去掉时候的id："+registerEntity.getBishe_register_id());

        session.removeAttribute("register");
        session.invalidate();

        System.out.println("已经从session中去掉时候的id："+registerEntity.getBishe_register_id());
    }
}
