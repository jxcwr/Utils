package com.jxc.utils.realTimeMessage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author jxc
 * @version 1.0
 * @description TODD webSocket（实时推送消息）的配置类，开启实时推送
 * @date 2022年12月01日 10:11
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
