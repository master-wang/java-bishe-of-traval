package com.acat.service.impl;

import com.acat.dao.CollectDao;
import com.acat.dao.TourDao;
import com.acat.entity.TourEntity;
import com.acat.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("recommendService")
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    private CollectDao collectDao;

    @Autowired
    private TourDao tourDao;

    public List<Integer> getTourEntityByRecommend(Integer bishe_collect_register_id){
        return collectDao.showCollect(bishe_collect_register_id);
    }

    public String getTourType(Integer bishe_tour_id){
        return tourDao.getTourType(bishe_tour_id);
    }

    public List<TourEntity> getTourEntityByType(String bishe_tour_type){
        return tourDao.getTourEntityByType(bishe_tour_type);
    }
}
