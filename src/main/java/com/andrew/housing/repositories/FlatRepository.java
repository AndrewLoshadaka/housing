package com.andrew.housing.repositories;

import com.andrew.housing.entity.Flat;
import com.andrew.housing.entity.Floor;
import com.andrew.housing.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FlatRepository extends JpaRepository<Flat, Integer> {
    List<Flat> findByOwner(Owner owner);
    List<Flat> findByFloor(Floor floor);
    @Query("SELECT DISTINCT f FROM Flat f LEFT JOIN FETCH f.counters c LEFT JOIN FETCH c.type LEFT JOIN FETCH c.readings r")
    List<Flat> findAllWithCountersAndReadings();
}
