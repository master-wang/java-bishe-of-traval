package com.acat.service.impl;

import com.acat.dao.LunboImgDao;
import com.acat.entity.LunboImgEntity;
import com.acat.service.LunboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("lunboService")
public class LunboServiceImpl implements LunboService {

    @Autowired
    private LunboImgDao lunboImgDao;

    public void addLunboImg(LunboImgEntity lunboImgEntity){
        lunboImgDao.save(lunboImgEntity);
    }

    public List<LunboImgEntity> getLunboImg(){
        return lunboImgDao.getLunboImg();
    }

    public void deleteAllLunboImg(){
        lunboImgDao.deleteAllLunboImg();
    }

}
