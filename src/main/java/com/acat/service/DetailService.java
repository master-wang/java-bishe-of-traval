package com.acat.service;

import com.acat.entity.DetailEntity;

public interface DetailService {

    void addDetail(DetailEntity detailEntity);

    DetailEntity getDetailByTourId(Integer bishe_tour_id);

}
