package com.mobylis.fr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import reactor.core.publisher.Flux;

import java.util.stream.Collectors;

/**
 * @author ANDRE
 * @since 21/02/2018
 */
@RunWith(MockitoJUnitRunner.class)
public class UnitTest {

    @Test
    public void name() throws Exception {

        final Flux<String> just = Flux.just("A", "B", "C", "D", "E");

        just
                .as(stringFlux -> 'A')
                .log();


    }
}
