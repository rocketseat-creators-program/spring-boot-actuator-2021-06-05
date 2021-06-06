package com.example.actuator.entity;

import com.example.actuator.util.GeneratorUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "user")
public class User {

    @Id
    private String id;

    private String name;
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    private LocalDate birthday;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private boolean active;

    @PrePersist
    private void prePersist() {
        this.active = true;
        this.id = GeneratorUtils.uuid();
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
