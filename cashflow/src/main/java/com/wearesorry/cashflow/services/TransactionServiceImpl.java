package com.wearesorry.cashflow.services;

import com.wearesorry.cashflow.entities.Transaction;
import com.wearesorry.cashflow.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    TransactionServiceImpl(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }
    TransactionServiceImpl(){};

    @Override
    public Transaction save(Transaction transaction) {
        return this.transactionRepository.save(transaction);
    }

    @Override
    public Iterable<Transaction> getAllTransactionsBySphere(UUID sphereId) {
        return this.transactionRepository.getAllTransactionsBySphere(sphereId);
    }

    @Override
    public Iterable<Transaction> getAllTransactionsByUser(UUID userId) {
        return null;
        //return this.transactionRepository.getAllTransactionsByUser(userId);
    }
}
