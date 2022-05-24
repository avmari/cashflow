package com.wearesorry.cashflow.repositories;

import com.wearesorry.cashflow.entities.Transaction;
import com.wearesorry.cashflow.projections.ExpenseDistribution;
import com.wearesorry.cashflow.projections.Expenses;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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
            "from Transaction tr where tr.card.user.id = :userId and tr.date BETWEEN :beginning and :ending GROUP BY tr.date")
    Iterable<Expenses> getExpenses(@Param("userId") UUID userId, @Param("beginning") LocalDate beginning, @Param("ending") LocalDate ending);

    @Query("SELECT " +
            "tr.sphere.name as name, " +
            "(SELECT round(sum(amount)*100/(SELECT sum(t.amount) from Transaction t " +
            "where t.sphere.user.id = :userId and t.date BETWEEN :beginning and :ending), 0) " +
            "from Transaction where card.user.id = :userId and sphere.name = tr.sphere.name " +
            "and date BETWEEN :beginning and :ending) as value " +
            "from Transaction tr where tr.card.user.id = :userId and tr.date BETWEEN :beginning and :ending GROUP BY tr.sphere.name")
    Iterable<ExpenseDistribution> getExpenseDistribution(@Param("userId") UUID userId, @Param("beginning") LocalDate beginning, @Param("ending") LocalDate ending);
}
