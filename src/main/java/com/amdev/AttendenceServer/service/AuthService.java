package com.amdev.AttendenceServer.service;

import com.amdev.AttendenceServer.dto.UserDTO;
import com.amdev.AttendenceServer.entities.User;
import com.amdev.AttendenceServer.enums.UserRole;
import com.amdev.AttendenceServer.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;


    @PostConstruct
    private void createAdminUser(){
        User optionalUser = userRepository.findByUserRole(UserRole.ADMIN);

        if (optionalUser == null){
            User user = new User();

            user.setName("Admin");
            user.setEmail("admin@gmail.com");
            user.setPassword("admin");
            user.setUserRole(UserRole.ADMIN);

            userRepository.save(user);
            System.out.println("Admin user created!");

        }else{
            System.out.println("Admin user already exists");
        }
    }


    public UserDTO login(UserDTO user){
        Optional<User> dbUser = userRepository.findByEmail(user.getEmail());

        if(dbUser.isPresent() && user.getPassword().equals(dbUser.get().getPassword())){
            return dbUser.get().getDto();
        }
        return null;
    }

}
