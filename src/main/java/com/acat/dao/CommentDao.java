package com.acat.dao;

import com.acat.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentDao extends JpaRepository<CommentEntity, Integer> {

    @Query(value = "select en from CommentEntity en where en.bishe_comment_tour_id=?1")
    List<CommentEntity> showTourCollect(Integer bishe_comment_tour_id);

    @Query(value = "select en from CommentEntity en")
    List<CommentEntity> getAllBy();

    @Transactional
    @Modifying
    @Query(value = "delete from CommentEntity en where en.bishe_comment_id=?1")
    void deleteComment(Integer bishe_comment_id);
}
