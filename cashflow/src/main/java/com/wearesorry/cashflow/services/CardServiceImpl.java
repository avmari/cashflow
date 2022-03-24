package com.wearesorry.cashflow.services;

import com.wearesorry.cashflow.entities.Card;
import com.wearesorry.cashflow.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CardServiceImpl implements CardService{
    @Autowired
    private CardRepository cardRepository;

    CardServiceImpl(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }
    CardServiceImpl(){};

    @Override
    public Card save(Card card) {
        return this.cardRepository.save(card);
    }

    @Override
    public Iterable<Card> getAllUsersCards(UUID userId) {
        return this.cardRepository.getAllUsersCards(userId);
    }

    @Override
    public void deleteById(UUID id) {
        this.cardRepository.deleteById(id);
    }

    @Override
    public void updateAmount(int amount, UUID cardId) {
        this.cardRepository.updateAmount(amount, cardId);
    }
}
