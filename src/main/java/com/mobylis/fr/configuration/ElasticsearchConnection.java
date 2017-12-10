package com.mobylis.fr.configuration;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;

/**
 * @author ANDRE
 * @since 10/12/2017
 */
@Configuration
public class ElasticsearchConnection {

    @EventListener(ApplicationReadyEvent.class)
    public void initialiseElasticsearchConnection() {

        System.out.println("hello world, I have just started up");

    }

    @EventListener(ContextClosedEvent.class)
    public void closeElasticSearchConnection() {

        System.out.println("hello world, I have just close");

    }

}
