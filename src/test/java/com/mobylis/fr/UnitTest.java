package com.mobylis.fr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Flux;

/**
 * @author ANDRE
 * @since 21/02/2018
 */
@RunWith(MockitoJUnitRunner.class)
public class UnitTest {

    @Test
    public void name() throws Exception {

        Flux<String> intervalFlux2 = Flux.just("{A}", "{B}", "{C}")
                .map(source -> {

                    // Sleep 1 s
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }

                    return "item " + source;
                });

        intervalFlux2.subscribe(System.out::println);
        Thread.sleep(20000);
    }
}
