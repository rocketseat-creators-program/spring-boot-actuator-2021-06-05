package com.example.actuator.monitoring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.net.URLConnection;

@Component
public class InternetHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if (this.checkInternetConnection()) {
            return Health.up()
                    .withDetail("message", "Connection established successfully.")
                    .build();
        }
        return Health.down()
                .withDetail("message", "Unable to establish a connection.")
                .build();
    }

    private boolean checkInternetConnection() {
        try {
            URL url = new URL("https://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
