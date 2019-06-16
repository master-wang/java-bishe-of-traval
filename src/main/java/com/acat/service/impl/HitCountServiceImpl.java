package com.acat.service.impl;

import com.acat.dao.HitCountDao;
import com.acat.entity.HitcountEntity;
import com.acat.service.HitCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("hitCountService")
public class HitCountServiceImpl implements HitCountService {

    @Autowired
    private HitCountDao hitCountDao;

    /**
     * 添加点击次数
     * @param hitcountEntity
     */
    public void saveHitCount(HitcountEntity hitcountEntity){
        hitcountEntity.setBishe_hitcount_count(hitcountEntity.getBishe_hitcount_count()+1);
        hitCountDao.save(hitcountEntity);
    }

    public List<Integer> getBishe_hitcount_tour_id(){
        return hitCountDao.getBishe_hitcount_tour_id();
    }
}
