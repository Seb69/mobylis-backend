package com.mobylis.fr.repository;

import com.mobylis.fr.domain.Deck;
import com.mobylis.fr.mock.Desk_Mock;
import org.junit.runner.RunWith;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tester : SuperObjectRepository
 *
 * @author ANDRE
 * @since 18/02/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SuperObjectRepository_Test {

    @Autowired
    SuperObjectRepository superObjectRepository;


    @Test
    public void save() throws Exception {

        // BUILD
        Deck desk = Desk_Mock.createB();


        // MOCK


        // OPERATE
        superObjectRepository.save(desk);


        // CHECK


    }
}
    