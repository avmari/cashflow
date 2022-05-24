package com.wearesorry.cashflow.services;

import com.wearesorry.cashflow.entities.Card;
import com.wearesorry.cashflow.entities.User;
import com.wearesorry.cashflow.repositories.CardRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CardServiceImpl implements CardService{
    @Autowired
    private CardRepository cardRepository;

    @Override
    public Card save(Card card) {
        return this.cardRepository.save(card);
    }

    @Override
    public Iterable<Card> getAllUserCards(UUID userId) {
        return this.cardRepository.getAllUserCards(userId);
    }

    @Override
    public void deleteById(UUID id) {
        this.cardRepository.deleteById(id);
    }

    @Override
    public void updateAmount(int amount, UUID cardId) {
        this.cardRepository.updateAmount(amount, cardId);
    }

    @Override
    public int getRemainingFunds(UUID userId){
        return this.cardRepository.getRemainingFunds(userId);
    }

    @Override
    public void createBasicCards(User user){
        save(new Card(UUID.randomUUID(), user, "Card", 0, "credit_card"));
        save(new Card(UUID.randomUUID(), user, "Wallet", 0, "account_balance_wallet"));
    }

    @Override
    public void editCard(Card card){
        this.cardRepository.editCard(card.getName(), card.getAmount(), card.getId());
    }

}
