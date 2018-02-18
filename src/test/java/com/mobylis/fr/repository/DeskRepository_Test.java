package com.mobylis.fr.repository;

import com.mobylis.fr.domain.Desk;
import com.mobylis.fr.mock.Desk_Mock;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

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

        final Desk save = deskRepository.save(Desk_Mock.createB());

        Assert.assertNotNull(save);
        Assert.assertEquals(BigDecimal.valueOf(570L), save.getPrice());
    }

}
    