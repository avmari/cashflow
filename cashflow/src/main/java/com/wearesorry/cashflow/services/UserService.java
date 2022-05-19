package com.wearesorry.cashflow.services;

import com.wearesorry.cashflow.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    User save(User user);
    Iterable<User> getAllUsers();
    void updateStatus(int newStatus, UUID userId);
    boolean canRegister(String name, String email);
    Optional<User> findByEmail(String email);
    Optional<User> getUser(UUID userId);
    Iterable<User> getUsersWithRequestedStatus();
}
