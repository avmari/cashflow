package com.wearesorry.cashflow.controllers;

import com.wearesorry.cashflow.entities.Card;
import com.wearesorry.cashflow.services.CardService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/cards")
@AllArgsConstructor
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/createCard")
    public Card createCard(@RequestBody Card card){
        return this.cardService.save(card);
    }

    @GetMapping("/getAllUserCards/{userId}")
    public Iterable<Card> getAllUserCards(@PathVariable UUID userId){
        return this.cardService.getAllUserCards(userId);
    }

    @PostMapping("/editCard")
    public void editCard(@RequestBody Card card){
        this.cardService.editCard(card);
    }

}
