package com.acat.service;

import com.acat.entity.UserInfoEntity;

import java.util.List;

public interface UserInfoService {

    void addUserInfo(UserInfoEntity userInfoEntity);

    void updateUserInfo(UserInfoEntity userInfoEntity);

    Integer getUserInfoIdByRegisterId(Integer bishe_user_info_register_id);

    UserInfoEntity getUserInfoById(Integer bishe_user_info_id);

    String getUserInfoNickById(Integer bishe_user_info_id);

    String getImagePath(Integer bishe_user_info_register_id);

    List<UserInfoEntity> getList();

    void deleteUserInfo(Integer bishe_user_info_id);
}
