package com.acat.dao;

import com.acat.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserInfoDao extends JpaRepository<UserInfoEntity,Integer> {

    /**
     * 根据登录的id获取用户信息的id
     * @param bishe_user_info_register_id
     * @return
     */
    @Query(value = "select en.bishe_user_info_id from UserInfoEntity en where en.bishe_user_info_register_id=?1")
    Integer getUserInfoIdByRegisterId(Integer bishe_user_info_register_id);

    /**
     *
     * @param bishe_user_info_id
     * @return
     */
    @Query(value = "select en.bishe_user_info_nike from UserInfoEntity en where en.bishe_user_info_id=?1")
    String getUserInfoNickById(Integer bishe_user_info_id);

    /**
     *
     * @return
     */
    @Query(value = "select en from UserInfoEntity en where en.bishe_user_info_id=?1")
    UserInfoEntity getUserInfoEntityById(Integer bishe_user_info_id);


    @Query(value = "select en.bishe_user_info_image from UserInfoEntity en where en.bishe_user_info_register_id=?1")
    String getImagePath(Integer bishe_user_info_register_id);

    @Query(value = "select en from UserInfoEntity en")
    List<UserInfoEntity> getList();

    @Transactional
    @Modifying
    @Query(value = "delete from UserInfoEntity en where en.bishe_user_info_id=?1")
    void deleteUserInfo(Integer bishe_user_info_id);
}
