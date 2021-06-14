package com.example.actuator.monitoring;

import com.example.actuator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UsersInfoContributor implements InfoContributor {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> userDetails = new HashMap();
            userDetails.put("total", this.userRepository.count());
            userDetails.put("actives", this.userRepository.countByActive(true));
            userDetails.put("inactives", this.userRepository.countByActive(false));
        builder.withDetail("userDetails", userDetails);
    }

}
