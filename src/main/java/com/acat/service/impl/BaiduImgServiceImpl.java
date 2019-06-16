package com.acat.service.impl;

import com.acat.dao.BaiduImgDao;
import com.acat.entity.BaiduImgEntity;
import com.acat.service.BaiduImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("baiduImgService")
public class BaiduImgServiceImpl implements BaiduImgService {

    @Autowired
    private BaiduImgDao baiduImgDao;

    public void addBaiduImg(BaiduImgEntity baiduImgEntity){
        baiduImgDao.save(baiduImgEntity);
    }

}
