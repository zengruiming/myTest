package com.ruiming.webclient.controller;

import com.ruiming.webclient.entity.Result;
import com.ruiming.webclient.entity.StatusCode;
import com.ruiming.webclient.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    private static Logger log= LoggerFactory.getLogger(PostController.class);
    @Autowired
    private PostService postService;
    @GetMapping("index")
    public Result testWithCookie(){
        return new Result(true, StatusCode.OK,"请求成功");
    }
}
