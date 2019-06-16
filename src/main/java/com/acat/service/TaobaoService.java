package com.acat.service;

import com.acat.entity.TaobaoDto.DataResponse;

public interface TaobaoService {

    DataResponse getAddress(String ip);

}
