package com.wearesorry.cashflow.repositories;

import com.wearesorry.cashflow.entities.Transaction;
import com.wearesorry.cashflow.projections.Expenses;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, UUID> {

    @Query("SELECT tr from Transaction tr where tr.sphere.id = :sphereId")
    Iterable<Transaction> getAllTransactionsBySphere(@Param("sphereId") UUID sphereId);

    @Query("SELECT tr from Transaction tr where tr.card.user.id = :userId")
    Iterable<Transaction> getAllTransactionsByUser(@Param("userId") UUID userId);

    @Query("SELECT sum(amount) from Transaction t where t.card.user.id = :userId")
    int getTotalAmountSpent(@Param("userId") UUID userId);

    @Query("SELECT " +
            "tr.date as name, " +
            "(SELECT sum(amount) from Transaction where card.user.id = :userId and date = tr.date) as value " +
            "from Transaction tr where tr.card.user.id = :userId GROUP BY tr.date")
    Iterable<Expenses> getExpenses(@Param("userId") UUID userId);
}
