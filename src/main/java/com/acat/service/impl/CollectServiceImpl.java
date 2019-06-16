package com.acat.service.impl;

import com.acat.dao.CollectDao;
import com.acat.entity.CollectEntity;
import com.acat.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("collectService")
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectDao collectDao;

    //
    public void addCollect(CollectEntity collectEntity){
        collectDao.save(collectEntity);
    }

    public void deleteByBishe_collect_id(Integer bishe_collect_tour_id,Integer bishe_collect_register_id){
        collectDao.deleteByBishe_collect_id(bishe_collect_tour_id,bishe_collect_register_id);
    }

    public List<Integer> showCollect(Integer bishe_collect_register_id){
        List<Integer> list = collectDao.showCollect(bishe_collect_register_id);
        return list;
    }
}
