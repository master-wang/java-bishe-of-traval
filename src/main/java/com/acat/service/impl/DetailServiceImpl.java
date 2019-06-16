package com.acat.service.impl;

import com.acat.dao.DetailDao;
import com.acat.entity.DetailEntity;
import com.acat.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("detailService")
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailDao detailDao;

    public void addDetail(DetailEntity detailEntity) {
        detailDao.save(detailEntity);
    }

    public DetailEntity getDetailByTourId(Integer bishe_tour_id) {
        return detailDao.getDetailByTourId(bishe_tour_id);
    }
}
