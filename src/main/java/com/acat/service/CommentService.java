package com.acat.service;

import com.acat.entity.CommentEntity;

import java.util.List;

public interface CommentService {

    /**
     * 添加评论
     * @param commentEntity
     */
    void addComment(CommentEntity commentEntity);

    /**
     * 显示所有的评论
     * @return
     */
    List<CommentEntity> getAllComment();

    /**
     * 显示单个景点的评论
     * @param bishe_comment_tour_id
     * @return
     */
    List<CommentEntity> showTourCollect(Integer bishe_comment_tour_id);

    /**
     * 删除评论
     * @param bishe_comment_id
     */
    void deleteComment(Integer bishe_comment_id);
}
