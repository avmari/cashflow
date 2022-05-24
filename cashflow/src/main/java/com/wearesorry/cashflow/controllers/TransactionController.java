package com.wearesorry.cashflow.controllers;

import com.wearesorry.cashflow.entities.Transaction;
import com.wearesorry.cashflow.projections.ExpenseDistribution;
import com.wearesorry.cashflow.projections.Expenses;
import com.wearesorry.cashflow.services.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/getExpenses/{userId}/{beginning}/{ending}")
    public Iterable<Expenses> getExpenses(@PathVariable UUID userId, @PathVariable String beginning, @PathVariable String ending){
        return this.transactionService.getExpenses(userId, LocalDate.parse(beginning), LocalDate.parse(ending));
    }

    @GetMapping("/getExpenseDistribution/{userId}/{beginning}/{ending}")
    public Iterable<ExpenseDistribution> getExpenseDistribution(@PathVariable UUID userId, @PathVariable String beginning, @PathVariable String ending){
        return this.transactionService.getExpenseDistribution(userId, LocalDate.parse(beginning), LocalDate.parse(ending));
    }

}
