package com.example.actuator.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class UserDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    private String email;

    @NotEmpty
    private String phoneNumber;

    @NotNull
    private LocalDate birthday;

    private boolean active;

}
