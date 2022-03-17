package com.wearesorry.cashflow.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Sphere getSphere() {
        return sphere;
    }

    public void setSphere(Sphere sphere) {
        this.sphere = sphere;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    private int amount;

}
