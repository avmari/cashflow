package com.wearesorry.cashflow.services;

import com.wearesorry.cashflow.entities.Card;

import java.util.UUID;

public interface CardService {
    Card save(Card card);
    Iterable<Card> getAllUsersCards(UUID userId);
    void deleteById(UUID id);
    void updateAmount(int amount, UUID cardId);
}
