package com.wearesorry.cashflow.services;

import com.wearesorry.cashflow.entities.User;
import com.wearesorry.cashflow.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public void updateStatus(int newStatus, UUID userId) {
        this.userRepository.updateStatus(newStatus, userId);
    }

    public boolean canRegister(String name, String email) {
        if (!userRepository.findByName(name).isEmpty()) {
            return false;
        }
        if (!userRepository.findByEmail(email).isEmpty()) {
            return false;
        }
        return true;
    }
}
