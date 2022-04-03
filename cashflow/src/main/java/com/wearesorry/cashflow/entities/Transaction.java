package com.wearesorry.cashflow.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sphere_id", columnDefinition="uuid not null")
    private Sphere sphere;

    @ManyToOne
    @JoinColumn(name = "card_id", columnDefinition="uuid not null")
    private Card card;

    private int amount;
    private LocalDate date;

}
