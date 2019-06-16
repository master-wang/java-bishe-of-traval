package com.acat.service.impl;

import com.acat.dao.UserInfoDao;
import com.acat.entity.UserInfoEntity;
import com.acat.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    public void addUserInfo(UserInfoEntity userInfoEntity){
        userInfoDao.save(userInfoEntity);
    }

    public void updateUserInfo(UserInfoEntity userInfoEntity){
        userInfoDao.save(userInfoEntity);
    }

    public Integer getUserInfoIdByRegisterId(Integer bishe_user_info_register_id){
        return userInfoDao.getUserInfoIdByRegisterId(bishe_user_info_register_id);
    }

    public UserInfoEntity getUserInfoById(Integer bishe_user_info_id){
        return userInfoDao.getUserInfoEntityById(bishe_user_info_id);
    }

    public String getUserInfoNickById(Integer bishe_user_info_id){
        return userInfoDao.getUserInfoNickById(bishe_user_info_id);
    }

    public String getImagePath(Integer bishe_user_info_register_id){
        return userInfoDao.getImagePath(bishe_user_info_register_id);
    }

    public List<UserInfoEntity> getList(){
        return userInfoDao.getList();
    }

    public void deleteUserInfo(Integer bishe_user_info_id){
        userInfoDao.deleteUserInfo(bishe_user_info_id);
    }



}
