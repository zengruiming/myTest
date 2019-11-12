package com.ruiming.webclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    private static Logger log= LoggerFactory.getLogger(Test.class);
    @GetMapping("index")
    public void testWithCookie(){

    }
}
