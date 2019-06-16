package com.acat.service.impl;

import com.acat.service.AreaMapService;
import com.acat.util.LiUtil;
import org.springframework.stereotype.Service;

@Service("areaMapService")
public class AreaMapServiceImpl implements AreaMapService {

    private static final String GAODE_MAP_FENDUAN1 = "https://restapi.amap.com/v3/staticmap?location=";

    private static final String GAODE_MAP_FENDUAN2 = "&zoom=10&size=750*300&markers=mid,,A:116.481485,39.990464&key=af85e8acba9f8b5fc1131299292c32cd";

    public String getAreaMapUrl(String address){

        String li = LiUtil.getCoordinate(address);

        return GAODE_MAP_FENDUAN1 + li + GAODE_MAP_FENDUAN2;
    }

}
