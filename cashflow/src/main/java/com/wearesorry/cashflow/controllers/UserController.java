package com.wearesorry.cashflow.controllers;

import com.wearesorry.cashflow.entities.User;
import com.wearesorry.cashflow.services.CardService;
import com.wearesorry.cashflow.services.TransactionService;
import com.wearesorry.cashflow.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CardService cardService;
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/requestVIP")
    User becomeVIP(@RequestBody User user){
        this.userService.updateStatus(2, user.getId());
        return this.userService.getUser(user.getId()).get();
    }

    @PostMapping("/signIn")
    ResponseEntity<User> signIn(@RequestBody User user){
        User authUser = this.userService.findByEmail(user.getEmail()).get();
        if(authUser == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(authUser.getPassword().equals(user.getPassword()))
            return new ResponseEntity<>(authUser, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/requestedVIP")
    Iterable<User> getUsersWithRequestedStatus(){
        return this.userService.getUsersWithRequestedStatus();
    }

    @PostMapping("/setVIP")
    User setVIP(@RequestBody User user){
        this.userService.updateStatus(1, user.getId());
        return this.userService.getUser(user.getId()).get();
    }

    @GetMapping("/getTotalAmountSpent/{userId}")
    int getTotalAmountSpent(@PathVariable UUID userId){
        return this.transactionService.getTotalAmountSpent(userId);
    }

    @GetMapping("/getRemainingFunds/{userId}")
    int getRemainingFunds(@PathVariable UUID userId){
        return this.cardService.getRemainingFunds(userId);
    }
}
