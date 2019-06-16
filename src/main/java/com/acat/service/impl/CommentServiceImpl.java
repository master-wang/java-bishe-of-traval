package com.acat.service.impl;

import com.acat.dao.CommentDao;
import com.acat.entity.CommentEntity;
import com.acat.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    public void addComment(CommentEntity commentEntity){
        commentDao.save(commentEntity);
    }

    public List<CommentEntity> getAllComment(){
        return commentDao.getAllBy();
    }

    public List<CommentEntity> showTourCollect(Integer bishe_comment_tour_id){
        return commentDao.showTourCollect(bishe_comment_tour_id);
    }

    public void deleteComment(Integer bishe_comment_id){
        commentDao.deleteComment(bishe_comment_id);
    }
}
