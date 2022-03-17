package com.wearesorry.cashflow.repositories;

import com.wearesorry.cashflow.entities.Sphere;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SphereRepository extends CrudRepository<Sphere, UUID> {
}
