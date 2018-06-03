package com.mobylis.fr.service;

import com.cloudinary.Cloudinary;
import com.mobylis.fr.configuration.TestConfiguration;
import com.mobylis.fr.service.file.FileServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.Map;

/**
 * Tester : FileService
 *
 * @author ANDRE
 * @since 03/03/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestConfiguration
public class FileServiceImpl_IntegrationTest {

    @Autowired
    FileServiceImpl fileService;

    @MockBean(answer = Answers.RETURNS_DEEP_STUBS)
    Cloudinary cloudinary;

    @Test
    public void upload() throws Exception {

        // BUILD
        File file = new File("src/test/resources/test.jpg");

        // MOCK
        Mockito.when(cloudinary.uploader().upload(ArgumentMatchers.any(), ArgumentMatchers.anyMap())).thenReturn(Map.of("public_id", "dsqdqsd", "format", "jpg"));

        // OPERATE
        //final String upload = fileService.upload(file);

        // CHECK
        //System.out.println(upload);
        //Assert.assertNotNull(upload);


    }
}
    