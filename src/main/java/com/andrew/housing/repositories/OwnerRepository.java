package com.andrew.housing.repositories;

import com.andrew.housing.entity.Flat;
import com.andrew.housing.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    Optional<Owner> findByPassport(String passport);
    List<Owner> findByFlats(Flat flat);
}
