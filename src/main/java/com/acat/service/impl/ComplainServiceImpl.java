package com.acat.service.impl;

import com.acat.dao.ComplainDao;
import com.acat.entity.ComplainEntity;
import com.acat.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("complainService")
public class ComplainServiceImpl implements ComplainService {


    @Autowired
    private ComplainDao complainDao;

    public void addComplain(ComplainEntity complainEntity){
        complainDao.save(complainEntity);
    }

}
