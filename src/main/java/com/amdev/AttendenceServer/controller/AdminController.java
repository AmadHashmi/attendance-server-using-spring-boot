package com.amdev.AttendenceServer.controller;

import com.amdev.AttendenceServer.dto.UserDTO;
import com.amdev.AttendenceServer.service.AdminService;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create-user")
    public ResponseEntity<?> signupUser(@RequestBody UserDTO dto){
        try {
            UserDTO createdUser = adminService.createUser(dto);
            return new ResponseEntity<>(createdUser, HttpStatus.OK);
        }catch (EntityExistsException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }catch (Exception e){
            return  new ResponseEntity<>("User not created, come again later", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
