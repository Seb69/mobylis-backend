package com.mobylis.fr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ANDRE
 * @since 03/12/2017
 */
@RestController
public class TestController {

    @GetMapping("test")
    public String test() {
        return "test";
    }

}
