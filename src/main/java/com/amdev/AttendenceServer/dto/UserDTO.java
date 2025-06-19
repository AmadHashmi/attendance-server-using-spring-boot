package com.amdev.AttendenceServer.dto;

import com.amdev.AttendenceServer.enums.UserRole;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private String name;
    private UserRole userRole;
}
