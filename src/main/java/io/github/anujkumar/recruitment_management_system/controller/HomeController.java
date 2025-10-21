package io.github.anujkumar.recruitment_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anujkumar.recruitment_management_system.entity.User;
import io.github.anujkumar.recruitment_management_system.service.UserService;

@RestController
@RequestMapping("/rms")
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String getMethodName() {
        return new String("hello! welcome to the rms");
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user) {
        try {
            if (user.getProfile() != null) {
                user.getProfile().setApplicant(user); // set back-reference
            }
            return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
