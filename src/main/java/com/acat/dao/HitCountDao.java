package com.acat.dao;

import com.acat.entity.HitcountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface HitCountDao extends JpaRepository<HitcountEntity,Integer> {

    @Query(value = "select bishe_hitcount_tour_id from bishe_hitcount order by bishe_hitcount_count desc limit 4",nativeQuery = true)
    List<Integer> getBishe_hitcount_tour_id();

}
