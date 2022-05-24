package com.wearesorry.cashflow.services;

import com.wearesorry.cashflow.entities.User;
import com.wearesorry.cashflow.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
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
    public void updateStatus(int newStatus, UUID userId) {
        this.userRepository.updateStatus(newStatus, userId);
    }

    @Override
    public Optional<User> findByEmail(String email){
        return this.userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> getUser(UUID userId){
        return this.userRepository.findById(userId);
    }

    @Override
    public Iterable<User> getUsersWithRequestedStatus(){
        return this.userRepository.getUsersWithRequestedStatus();
    }

    public boolean canRegister(String email) {
        if (!userRepository.findByEmail(email).isEmpty()) {
            return false;
        }
        return true;
    }

}
