package com.acat.service;

import com.acat.entity.AddressDto.AddressResponse;

public interface AddressDataService {

    /**
     *
     * @param ip
     * @return
     */
    AddressResponse getAddressByIp(String ip);

}
