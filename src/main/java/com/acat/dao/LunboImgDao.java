package com.acat.dao;

import com.acat.entity.LunboImgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface LunboImgDao extends JpaRepository<LunboImgEntity,Integer> {

    @Query(value = "select en from LunboImgEntity en")
    List<LunboImgEntity> getLunboImg();

    @Transactional
    @Modifying
    @Query(value = "delete from LunboImgEntity en")
    void deleteAllLunboImg();
}
