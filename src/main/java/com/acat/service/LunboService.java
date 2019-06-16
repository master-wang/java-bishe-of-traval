package com.acat.service;

import com.acat.entity.LunboImgEntity;

import java.util.List;

public interface LunboService {

    void addLunboImg(LunboImgEntity lunboImgEntity);

    List<LunboImgEntity> getLunboImg();

    void deleteAllLunboImg();
}
