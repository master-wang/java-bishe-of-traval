package com.acat.dao;

import com.acat.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegisterDao extends JpaRepository<RegisterEntity,Integer> {

    @Query(value = "select e from RegisterEntity e where e.bishe_register_username=?1 and e.bishe_register_password=?2")
    RegisterEntity login(String bishe_register_username,String bishe_register_password);

    @Query(value = "select e from RegisterEntity e where e.bishe_register_id=?1")
    RegisterEntity getPassword(Integer bishe_register_id);
}
