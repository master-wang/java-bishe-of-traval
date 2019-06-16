package com.acat.service;

import com.acat.entity.TourEntity;

import java.util.List;

/**
 * 个性化推荐
 */
public interface RecommendService {

    List<Integer> getTourEntityByRecommend(Integer bishe_collect_register_id);

    String getTourType(Integer bishe_tour_id);

    List<TourEntity> getTourEntityByType(String bishe_tour_type);
}
