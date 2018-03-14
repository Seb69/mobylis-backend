package com.mobylis.fr.service;

import org.junit.runner.RunWith;
import org.mockito.*;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

/**
 * Tester : FileService
 *
 * @author ANDRE
 * @since 03/03/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServiceImpl_EndToEndTest {

    @Autowired
    FileServiceImpl fileService;


    @Test
    public void upload() throws Exception {

        // BUILD
        File file = new File("src/test/resources/test.jpg");


        // MOCK


        // OPERATE
        final String upload = fileService.upload(file);


        // CHECK
        System.out.println(upload);
        Assert.assertNotNull(upload);


    }
}
    