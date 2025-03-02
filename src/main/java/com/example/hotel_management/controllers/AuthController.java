package com.example.hotel_management.controllers;

import com.example.hotel_management.models.User;
import com.example.hotel_management.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return new ResponseEntity<>("Email already in use!", HttpStatus.BAD_REQUEST);
        }
        userRepository.save(user);
        String responseMessage = user.getUsername() + " you have successfully registered. Click here to login.";
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword())) {
            return new ResponseEntity<>("Login successful!", HttpStatus.OK);
        }

        return new ResponseEntity<>("Invalid email or password!", HttpStatus.UNAUTHORIZED);
    }

}