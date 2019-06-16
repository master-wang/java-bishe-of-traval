package com.acat.service;

import com.acat.entity.CityEntity;

import java.util.List;

public interface CityService {

    List<CityEntity> getCityList(Integer bishe_city_province_id);

}
