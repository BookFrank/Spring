package com.tazine.boot.listener;

import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by lina on 2017/11/23.
 */
public class ConfigDemo implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {


    private int serverPort;

    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
        this.serverPort = event.getEmbeddedServletContainer().getPort();
    }


    public int getServerPort(){
        return this.serverPort;
    }


}
