package com.wearesorry.cashflow.services;

import com.wearesorry.cashflow.entities.Card;
import com.wearesorry.cashflow.entities.User;

import java.util.UUID;

public interface CardService {
    Card save(Card card);
    Iterable<Card> getAllUserCards(UUID userId);
    int getRemainingFunds(UUID userId);
    void deleteById(UUID id);
    void updateAmount(int amount, UUID cardId);
    void createBasicCards(User user);
    void editCard(Card card);
}
