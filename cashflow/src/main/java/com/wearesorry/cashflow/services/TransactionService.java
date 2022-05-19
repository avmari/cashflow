package com.wearesorry.cashflow.services;

import com.wearesorry.cashflow.entities.Transaction;

import java.util.UUID;

public interface TransactionService {
    Transaction save(Transaction transaction);
    Iterable<Transaction> getAllTransactionsBySphere(UUID sphereId);
    Iterable<Transaction> getAllTransactionsByUser(UUID userId);
    int getTotalAmountSpent(UUID userId);
}
