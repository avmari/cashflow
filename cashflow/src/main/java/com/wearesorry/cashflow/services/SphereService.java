package com.wearesorry.cashflow.services;

import com.wearesorry.cashflow.entities.Sphere;
import com.wearesorry.cashflow.entities.User;

import java.util.UUID;

public interface SphereService {
    Sphere save(Sphere sphere);
    Iterable<Sphere> getAllUserSpheres(UUID userId);
    void deleteById(UUID id);
    void updateAmount(int amount, UUID sphereId);
    void createBasicSpheres(User user);
}
