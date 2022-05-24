package com.wearesorry.cashflow.controllers;

import com.wearesorry.cashflow.entities.User;
import com.wearesorry.cashflow.services.CardService;
import com.wearesorry.cashflow.services.SphereService;
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
    @Autowired
    private SphereService sphereService;

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

    @PostMapping("/signUp")
    ResponseEntity<User> signUp(@RequestBody User user){
        if(!this.userService.canRegister(user.getEmail()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        User newUser = this.userService.save(new User(UUID.randomUUID(), user.getName(), user.getEmail(), user.getPassword(), 0));
        this.sphereService.createBasicSpheres(newUser);
        this.cardService.createBasicCards(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
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
