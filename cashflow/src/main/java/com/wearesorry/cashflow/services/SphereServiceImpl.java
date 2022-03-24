package com.wearesorry.cashflow.services;

import com.wearesorry.cashflow.entities.Sphere;
import com.wearesorry.cashflow.repositories.SphereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SphereServiceImpl implements SphereService{
    @Autowired
    private SphereRepository sphereRepository;

    SphereServiceImpl(SphereRepository sphereRepository){
        this.sphereRepository = sphereRepository;
    }
    SphereServiceImpl(){};

    @Override
    public Sphere save(Sphere sphere) {
        return this.sphereRepository.save(sphere);
    }

    @Override
    public Iterable<Sphere> getAllUsersSpheres(UUID userId) {
        return this.sphereRepository.getAllUsersSpheres(userId);
    }

    @Override
    public void deleteById(UUID id) {
        this.sphereRepository.deleteById(id);
    }

    @Override
    public void updateAmount(int amount, UUID sphereId) {
        this.sphereRepository.updateAmount(amount, sphereId);
    }
}
