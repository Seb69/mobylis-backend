package com.mobylis.fr.configuration;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;

/**
 * @author ANDRE
 * @since 10/12/2017
 */
@Configuration
public class ElasticsearchConfig {

    @Value("${elasticsearch.scheme}")
    private String esScheme;

    @Value("${elasticsearch.host}")
    private String esHost;

    @Value("${elasticsearch.port}")
    private int esPort;

    private RestHighLevelClient client;

    @Bean
    public RestHighLevelClient restHighLevelClient() {

        final HttpHost httpHost = new HttpHost(esHost, esPort, esScheme);

        final RestClientBuilder restClientBuilder = RestClient.builder(httpHost);

        client = new RestHighLevelClient(restClientBuilder);

        return client;
    }

    @EventListener(ContextClosedEvent.class)
    public void closeElasticSearchConnection() throws IOException {

        this.client.close();
    }

}
