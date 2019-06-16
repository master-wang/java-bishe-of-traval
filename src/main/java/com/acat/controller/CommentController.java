package com.acat.controller;

import com.acat.entity.CommentEntity;
import com.acat.entity.RegisterEntity;
import com.acat.entity.UserInfoEntity;
import com.acat.service.CommentService;
import com.acat.service.UserInfoService;
import com.acat.vo.CommentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * #旅游景点的评论表
 * drop table if exists bishe_comment;
 * create table `bishe_comment`(
 *     `bishe_comment_id` int(10) not null auto_increment,
 *     `bishe_comment_content` varchar(100) not null COMMENT '旅游景点的评论内容',
 *     `bishe_comment_registerId` int(10) not null COMMENT '评论人的id',
 *     `bishe_comment_userInfoNick` varchar(20) not null COMMENT '评论人的昵称',
 *     `bishe_comment_tourId` int(10) not null COMMENT '评论的旅游景点的id',
 *     primary key (`bishe_comment_id`)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/comment")
@Api(value = "comment表",tags = {"搭建comment表的所有接口"})
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserInfoService userInfoService;


    @PostMapping("/addComment")
    @ApiOperation(value = "添加评论",notes = "添加评论")
    @ApiImplicitParam(value = "commentVo",name = "commentVo")
    public String addComment(@RequestBody CommentVo commentVo){

//        RegisterEntity registerEntity = (RegisterEntity)session.getAttribute("registerEntity");
//
//        if(registerEntity == null){
//            return "1";//没有登录,请先登录
//        }

//        int bishe_userInfo_id = userInfoService.getUserInfoIdByRegisterId(registerEntity.getBishe_register_id());
//        String bishe_userInfo_nick = userInfoService.getUserInfoNickById(bishe_userInfo_id);
//
//        CommentEntity commentEntity = new CommentEntity();
//        commentEntity.setBishe_comment_content(commentVo.getBishe_comment_content());
//        commentEntity.setBishe_comment_registerId(registerEntity.getBishe_register_id());
//        commentEntity.setBishe_comment_userInfoNick(bishe_userInfo_nick);
//        commentEntity.setBishe_comment_tourId(commentVo.getBishe_comment_tourId());
//        commentService.addComment(commentEntity);
//        return "2";//添加评论成功

        System.out.println("@@@@@@@@@@@@");
        System.out.println(commentVo);
        System.out.println("@@@@@@@@@@@@");

        int bishe_userInfo_id = userInfoService.getUserInfoIdByRegisterId(commentVo.getBishe_register_id());
        String bishe_userInfo_nick = userInfoService.getUserInfoNickById(bishe_userInfo_id);

        CommentEntity commentEntity = new CommentEntity();

        commentEntity.setBishe_comment_register_id(commentVo.getBishe_register_id());
        commentEntity.setBishe_comment_content(commentVo.getBishe_comment_content());
        commentEntity.setBishe_comment_tour_id(commentVo.getBishe_comment_tour_id());
        commentEntity.setBishe_comment_user_info_nick(bishe_userInfo_nick);

        commentService.addComment(commentEntity);
        return "2";//添加评论成功
    }

    @GetMapping("/showTourComment/{tour_id}")
    @ApiOperation(value = "查看单个景点的评论",notes = "查看单个景点的评论")
    @ApiImplicitParam(value = "tour_id",name = "tour_id")
    public List<CommentEntity> showTourCollect(@PathVariable("tour_id") Integer tour_id){
        List<CommentEntity> list = commentService.showTourCollect(tour_id);
        return list;
    }


    @GetMapping("/getAllComment")
    @ApiOperation(value = "查看全部的评论",notes = "查看全部的评论")
    public List<CommentEntity> getAllComment(){
        List<CommentEntity> list = commentService.getAllComment();
        return list;
    }

    @GetMapping("/deleteComment/{bishe_comment_id}")
    @ApiOperation(value = "删除景点的评论",notes = "删除景点的评论")
    @ApiImplicitParam(value = "bishe_comment_id",name = "bishe_comment_id")
    public String deleteComment(@PathVariable("bishe_comment_id") Integer bishe_comment_id){
        commentService.deleteComment(bishe_comment_id);
        return "1";//删除评论成功
    }
}
