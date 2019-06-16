package com.acat.service.impl;

import com.acat.dao.CityDao;
import com.acat.entity.CityEntity;
import com.acat.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("cityService")
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public List<CityEntity> getCityList(Integer bishe_city_province_id){
        return cityDao.getCityList(bishe_city_province_id);
    }
}
