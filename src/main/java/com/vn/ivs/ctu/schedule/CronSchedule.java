package com.vn.ivs.ctu.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronSchedule {
	@Scheduled(cron = "0 05 10 * * THU")
    public void doSomething() {
 
        System.out.println("Do some thing");
 
    }

}
