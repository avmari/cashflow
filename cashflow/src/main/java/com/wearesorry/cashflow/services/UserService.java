package com.wearesorry.cashflow.services;

import com.wearesorry.cashflow.entities.User;

import java.util.UUID;

public interface UserService {
    User save(User user);
    Iterable<User> getAllUsers();
    void deleteById(UUID id);
    void updateStatus(int newStatus, UUID userId);
    boolean canRegister(String name, String email);
}
