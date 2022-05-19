package com.wearesorry.cashflow.repositories;

import com.wearesorry.cashflow.entities.Sphere;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface SphereRepository extends CrudRepository<Sphere, UUID> {

    @Query("SELECT s from Sphere s where s.user.id = :userId")
    Iterable<Sphere> getAllUserSpheres(@Param("userId") UUID userId);

    @Modifying
    @Transactional
    @Query("UPDATE Sphere s set s.amount = s.amount + :amount where s.id = :sphereId")
    void updateAmount(@Param("amount") int amount, @Param("sphereId") UUID sphereId);
}
