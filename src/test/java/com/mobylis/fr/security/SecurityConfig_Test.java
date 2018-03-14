package com.mobylis.fr.security;

import com.mobylis.fr.MobylisApplication;
import com.mobylis.fr.configuration.TestConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.springSecurity;
import static org.springframework.web.reactive.function.client.ExchangeFilterFunctions.basicAuthentication;

/**
 * Tester : SecurityConfig
 *
 * @author ANDRE
 * @since 04/03/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestConfiguration
public class SecurityConfig_Test {

    @Autowired
    ApplicationContext context;

    WebTestClient webTestClient;

    @Before
    public void setup() {
        this.webTestClient = WebTestClient
                .bindToApplicationContext(this.context)
                // add Spring Security test Support
                .apply(springSecurity())
                .configureClient()
                .filter(basicAuthentication())
                .build();
    }

    @Test
    public void unauthorie() throws Exception {

        // BUILD


        // MOCK


        // OPERATE
        this.webTestClient.get().uri("/api/private/product/hello")
                .exchange()
                .expectStatus().isUnauthorized();


        // CHECK


    }
}
    