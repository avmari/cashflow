package com.wearesorry.cashflow.services;

import com.wearesorry.cashflow.entities.Transaction;
import com.wearesorry.cashflow.projections.ExpenseDistribution;
import com.wearesorry.cashflow.projections.Expenses;

import java.time.LocalDate;
import java.util.UUID;

public interface TransactionService {
    Transaction save(Transaction transaction);
    Iterable<Transaction> getAllTransactionsBySphere(UUID sphereId);
    int getTotalAmountSpent(UUID userId);
    Iterable<Expenses> getExpenses(UUID userId,  LocalDate beginning, LocalDate ending);
    Iterable<ExpenseDistribution> getExpenseDistribution(UUID userId, LocalDate beginning, LocalDate ending);
}
