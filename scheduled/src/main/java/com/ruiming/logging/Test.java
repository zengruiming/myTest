package com.ruiming.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Test {
    private int count = 0;
    //每六秒钟执行一次
    @Scheduled(cron = "*/6 * * * * ?")
    @Async
    void process() {
        log.info("ceshia ");
        System.out.println("定时任务：" + (count++));
    }
}
