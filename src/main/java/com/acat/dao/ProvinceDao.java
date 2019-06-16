package com.acat.dao;

import com.acat.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProvinceDao extends JpaRepository<ProvinceEntity,Integer> {

    @Query(value = "select en from ProvinceEntity en")
    List<ProvinceEntity> getProvinceList();

}
