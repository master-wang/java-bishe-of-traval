package com.acat.dao;

import com.acat.entity.ComplainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplainDao extends JpaRepository<ComplainEntity, Integer> {
}
