package com.acat.service.impl;

import com.acat.dao.RegisterDao;
import com.acat.entity.RegisterEntity;
import com.acat.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterDao registerDao;

    public void addRegister(RegisterEntity registerEntity){

        registerEntity.setBishe_register_flag(1);

        registerDao.save(registerEntity);
    }
    public RegisterEntity login(String bishe_register_username,String bishe_register_password){
        return registerDao.login(bishe_register_username,bishe_register_password);
    }

    public void updatePssword(RegisterEntity registerEntity){
        registerDao.save(registerEntity);
    }

    public RegisterEntity getPassword(Integer bishe_register_id){
        return registerDao.getPassword(bishe_register_id);
    }
}
