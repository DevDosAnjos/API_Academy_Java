package com.users.academyusers.controllers;


import com.users.academyusers.dto.RegisterRequest;
import com.users.academyusers.dto.UserRequest;
import com.users.academyusers.dto.UserResponse;
import com.users.academyusers.dto.UserUpdateResponse;
import com.users.academyusers.entities.User;
import com.users.academyusers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(RegisterRequest registerRequest){
        UserResponse response = userService.registerUser(registerRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping()
    public ResponseEntity<UserUpdateResponse> update(User user, UserRequest userRequest){
        UserUpdateResponse response = userService.updateUser(user, userRequest);
        return ResponseEntity.ok(response);
    }


}
