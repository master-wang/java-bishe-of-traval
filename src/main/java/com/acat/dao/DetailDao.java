package com.acat.dao;

import com.acat.entity.DetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DetailDao extends JpaRepository<DetailEntity,Integer> {

    @Query(value = "select en from DetailEntity en where en.bishe_tour_id=?1")
    DetailEntity getDetailByTourId(Integer bishe_tour_id);

}
