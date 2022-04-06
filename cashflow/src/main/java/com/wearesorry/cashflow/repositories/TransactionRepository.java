package com.wearesorry.cashflow.repositories;

import com.wearesorry.cashflow.entities.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, UUID> {

    @Query("SELECT tr from Transaction tr where tr.sphere.id = :sphereId")
    Iterable<Transaction> getAllTransactionsBySphere(@Param("sphereId") UUID sphereId);

    @Query("SELECT tr from Transaction tr where tr.card.id in (SELECT c.id from Card c where c.user.id = :userId)")
    Iterable<Transaction> getAllTransactionsByUser(@Param("userId") UUID userId);
}
