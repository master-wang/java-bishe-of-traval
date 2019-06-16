package com.acat.dao;

import com.acat.entity.CollectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CollectDao extends JpaRepository<CollectEntity,Integer> {

    //收藏

    //取消收藏
    @Transactional
    @Modifying
    @Query(value = "delete from CollectEntity en where en.bishe_collect_tour_id=?1 and en.bishe_collect_register_id=?2")
    void deleteByBishe_collect_id(Integer bishe_collect_tour_id,Integer bishe_collect_register_id);

    //查看我的收藏
    @Query(value = "select en.bishe_collect_tour_id from CollectEntity en where en.bishe_collect_register_id=?1")
    List<Integer> showCollect(Integer bishe_collect_register_id);
}
