package com.wearesorry.cashflow.services;

import com.wearesorry.cashflow.entities.Transaction;
import com.wearesorry.cashflow.projections.ExpenseDistribution;
import com.wearesorry.cashflow.projections.Expenses;
import com.wearesorry.cashflow.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CardService cardService;
    @Autowired
    private SphereService sphereService;

    @Override
    public Transaction save(Transaction transaction) {
        if(transaction.getAmount() > transaction.getCard().getAmount())
            return null;
        cardService.updateAmount(-transaction.getAmount(), transaction.getCard().getId());
        sphereService.updateAmount(transaction.getAmount(), transaction.getSphere().getId());
        return this.transactionRepository.save(transaction);
    }

    @Override
    public Iterable<Transaction> getAllTransactionsBySphere(UUID sphereId) {
        return this.transactionRepository.getAllTransactionsBySphere(sphereId);
    }

    @Override
    public int getTotalAmountSpent(UUID userId){
        return this.transactionRepository.getTotalAmountSpent(userId);
    }

    @Override
    public Iterable<Expenses> getExpenses(UUID userId,  LocalDate beginning, LocalDate ending){
        return this.transactionRepository.getExpenses(userId, beginning, ending);
    }

    @Override
    public Iterable<ExpenseDistribution> getExpenseDistribution(UUID userId, LocalDate beginning, LocalDate ending){
        return this.transactionRepository.getExpenseDistribution(userId, beginning, ending);
    }

}
