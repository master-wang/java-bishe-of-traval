package com.acat.service.impl;

import com.acat.dao.ProvinceDao;
import com.acat.entity.ProvinceEntity;
import com.acat.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceDao provinceDao;

    public List<ProvinceEntity> getProvinceList(){
        return provinceDao.getProvinceList();
    }

}
