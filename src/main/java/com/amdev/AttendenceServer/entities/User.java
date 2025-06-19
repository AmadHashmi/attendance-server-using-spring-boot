package com.amdev.AttendenceServer.entities;

import com.amdev.AttendenceServer.dto.UserDTO;
import com.amdev.AttendenceServer.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private UserRole userRole;


    public UserDTO getDto(){
        UserDTO dto = new UserDTO();

        dto.setId(id);
        dto.setName(name);
        dto.setUserRole(userRole);
        dto.setEmail(email);

        return dto;
    }


}
