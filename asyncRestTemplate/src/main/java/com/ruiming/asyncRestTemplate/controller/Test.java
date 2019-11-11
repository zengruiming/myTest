package com.ruiming.asyncRestTemplate.controller;

import com.ruiming.asyncRestTemplate.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    private static Logger log = LoggerFactory.getLogger(Test.class);
    @GetMapping("index")
    private Student run(){
        int a =10;
        Student var1 = new Student("zeng", 18, true);
        Student var2 = new Student("zeng", 18, true);
        Student var3 = new Student("zeng", 18, true);
        log.info("test");
        log.info("haha");

        return var1;
    }
}
