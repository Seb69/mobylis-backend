package com.mobylis.fr.repository;

import com.mobylis.fr.domain.Deck;
import com.mobylis.fr.mock.Desk_Mock;
import org.junit.runner.RunWith;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;


/**
 * Tester : DeskRepository
 *
 * @author ANDRE
 * @since 18/02/2018
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class DeskRepository_Test {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    DeskRepository deskRepository;

    @Before
    public void setUp() throws Exception {
        this.entityManager.persist(Desk_Mock.createA());
        this.entityManager.persist(Desk_Mock.createA());
        this.entityManager.persist(Desk_Mock.createA());
    }

    @Test
    public void save_desk_object() throws Exception {

        final Deck save = deskRepository.save(Desk_Mock.createB());

        Assert.assertNotNull(save);
        Assert.assertEquals(BigDecimal.valueOf(570L), save.getPrice());
    }

}
    