package com.wearesorry.cashflow.repositories;

import com.wearesorry.cashflow.entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    Optional <User> findByName(String name);
    Optional <User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User us set us.status = :newStatus where us.id = :userId")
    void updateStatus(@Param("newStatus") int newStatus, @Param("userId") UUID userId);

    @Query("SELECT us from User us where us.status = 2")
    Iterable<User> getUsersWithRequestedStatus();

}
