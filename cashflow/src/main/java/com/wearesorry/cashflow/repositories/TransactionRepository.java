package com.wearesorry.cashflow.repositories;

import com.wearesorry.cashflow.entities.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TransactionRepository extends CrudRepository<Transaction, UUID> {
}
