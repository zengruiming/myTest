package com.ruiming.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Test {
    private static Logger log= LoggerFactory.getLogger(Test.class);
    private int count = 0;
    //每六秒钟执行一次
    @Scheduled(cron = "*/6 * * * * ?")
    private void process() {
        log.info("ceshia ");
        System.out.println("定时任务1：" + (count++));
    }
}
