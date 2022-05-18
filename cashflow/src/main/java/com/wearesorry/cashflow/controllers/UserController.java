package com.wearesorry.cashflow.controllers;

import com.wearesorry.cashflow.entities.User;
import com.wearesorry.cashflow.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/VIP")
    User becomeVIP(@RequestBody User user){
        this.userService.updateStatus(2, user.getId());
        return this.userService.getUser(user.getId()).get();
    }

    @PostMapping("/signin")
    ResponseEntity<?> signIn(@RequestBody User user){
        User authUser = this.userService.findByEmail(user.getEmail()).get();
        if(authUser == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(authUser.getPassword().equals(user.getPassword()))
            return new ResponseEntity<>(authUser, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
