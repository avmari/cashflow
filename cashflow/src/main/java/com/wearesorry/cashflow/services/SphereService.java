package com.wearesorry.cashflow.services;

import com.wearesorry.cashflow.entities.Sphere;

import java.util.UUID;

public interface SphereService {
    Sphere save(Sphere sphere);
    Iterable<Sphere> getAllUsersSpheres(UUID userId);
    void deleteById(UUID id);
    void updateAmount(int amount, UUID sphereId);
}
