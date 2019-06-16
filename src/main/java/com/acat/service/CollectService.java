package com.acat.service;

import com.acat.entity.CollectEntity;

import java.util.List;

public interface CollectService {


    void addCollect(CollectEntity collectEntity);

    void deleteByBishe_collect_id(Integer bishe_collect_tour_id,Integer bishe_collect_register_id);

    List<Integer> showCollect(Integer bishe_collect_register_id);
}
