package com.acat.config;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;
import java.util.Set;

public class SocketConfig implements ServerApplicationConfig {

    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> ss) {
        // TODO Auto-generated method stub
        System.out.println("endPoint扫描到的数量："+ss.size());

        return ss;
    }

    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(
            Set<Class<? extends Endpoint>> ss) {
        // TODO Auto-generated method stub
        System.out.println("实现EndPoint接口的类数量："+ss.size());
        return null;
    }

}
