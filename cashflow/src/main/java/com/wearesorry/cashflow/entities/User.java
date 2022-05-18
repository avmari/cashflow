package com.wearesorry.cashflow.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="Users", uniqueConstraints= { @UniqueConstraint(columnNames = {"email"}) })
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String email;
    private String password;
    private int status; //0 - client, 1 - VIP-client, 2 - requested VIP, 3 - administrator

}
