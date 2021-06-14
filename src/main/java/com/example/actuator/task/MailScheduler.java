package com.example.actuator.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MailScheduler {

    @Scheduled(cron = "0 0 7 * * *")
    public void send() {
        // Send marketing e-mail to Users
    }

}
