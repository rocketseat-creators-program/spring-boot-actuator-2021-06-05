package com.example.actuator.service;

import com.example.actuator.entity.User;
import com.example.actuator.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User update(String id, User user) {
        User databaseUser = this.userRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(user, databaseUser, "id", "createdAt", "updatedAt");
        return this.userRepository.save(databaseUser);
    }

    public void changeState(String id) {
        User databaseUser = this.userRepository.findById(id).orElseThrow();
        databaseUser.setActive(databaseUser.isActive() ? false : true);
        this.userRepository.save(databaseUser);
    }

    public void deleteById(String id) {
        User databaseUser = this.userRepository.findById(id).orElseThrow();
        this.userRepository.delete(databaseUser);
    }


}
