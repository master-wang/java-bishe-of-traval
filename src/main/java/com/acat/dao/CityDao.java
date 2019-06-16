package com.acat.dao;

import com.acat.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityDao extends JpaRepository<CityEntity,Integer> {

    @Query(value = "select e from CityEntity e where e.bishe_city_province_id=?1")
    List<CityEntity> getCityList(Integer bishe_city_province_id);

}