package com.acat.service;

import com.acat.entity.HitcountEntity;

import java.util.List;

public interface HitCountService {

    /**
     * 添加点击次数
     * @param hitcountEntity
     */
    void saveHitCount(HitcountEntity hitcountEntity);

    /**
     * 查找旅游景点前4的bishe_hitcount_tourId
     * @return
     */
    List<Integer> getBishe_hitcount_tour_id();

}
