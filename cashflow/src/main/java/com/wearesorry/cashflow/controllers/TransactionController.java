package com.wearesorry.cashflow.controllers;

import com.wearesorry.cashflow.entities.Transaction;
import com.wearesorry.cashflow.projections.Expenses;
import com.wearesorry.cashflow.services.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/transactions")
@AllArgsConstructor
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/createTransaction")
    public Transaction createTransaction(@RequestBody Transaction transaction){
        return this.transactionService.save(transaction);
    }

    @GetMapping("/getExpenses/{userId}")
    public Iterable<Expenses> getExpenses(@PathVariable UUID userId){
        return this.transactionService.getExpenses(userId);
    }

}
