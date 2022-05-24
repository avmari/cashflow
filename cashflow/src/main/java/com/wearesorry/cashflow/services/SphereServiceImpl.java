package com.wearesorry.cashflow.services;

import com.wearesorry.cashflow.entities.Sphere;
import com.wearesorry.cashflow.entities.User;
import com.wearesorry.cashflow.repositories.SphereRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class SphereServiceImpl implements SphereService{

    private final String[] basicSpheres = new String[]{"Food", "Home", "Car", "Self-care", "Tech", "Pet", "Entertainment", "More"};
    private final String[] basicIcons = new String[]{"shopping_basket", "home", "directions_car", "spa", "computer", "pets", "star", "more_horiz"};

    @Autowired
    private SphereRepository sphereRepository;

    @Override
    public Sphere save(Sphere sphere) {
        return this.sphereRepository.save(sphere);
    }

    @Override
    public Iterable<Sphere> getAllUserSpheres(UUID userId) {
        return this.sphereRepository.getAllUserSpheres(userId);
    }

    @Override
    public void deleteById(UUID id) {
        this.sphereRepository.deleteById(id);
    }

    @Override
    public void updateAmount(int amount, UUID sphereId) {
        this.sphereRepository.updateAmount(amount, sphereId);
    }

    @Override
    public void createBasicSpheres(User user){
        for(int i = 0; i < 8; ++i){
            save(new Sphere(UUID.randomUUID(), user, basicSpheres[i], 0, basicIcons[i]));
        }
    }
}
