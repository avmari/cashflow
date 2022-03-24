package com.wearesorry.cashflow.repositories;

import com.wearesorry.cashflow.entities.Card;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface CardRepository extends CrudRepository<Card, UUID> {

    @Query("SELECT c from Card c where c.user.id = :userId")
    Iterable<Card> getAllUsersCards(@Param("userId") UUID userId);

    @Modifying
    @Transactional
    @Query("UPDATE Card c set c.amount = c.amount + :amount where c.id = :cardId")
    void updateAmount(@Param("amount") int amount, @Param("cardId") UUID cardId);

}
