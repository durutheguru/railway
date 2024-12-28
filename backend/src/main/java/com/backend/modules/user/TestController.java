package com.backend.modules.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/test")
public class TestController {

    private final UserRepository userRepository;

    @GetMapping
    public String testing() {
        return "Testing 12345!!!";
    }

    
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    
}


