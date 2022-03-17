package com.wearesorry.cashflow.repositories;

import com.wearesorry.cashflow.entities.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CardRepository extends CrudRepository<Card, UUID> {
}
