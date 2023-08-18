package com.andrew.housing.repositories;

import com.andrew.housing.entity.Counter;
import com.andrew.housing.entity.Flat;
import com.andrew.housing.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CounterRepository extends JpaRepository<Counter, Integer> {
    Counter findByFlatAndType(Flat flat, Type type);
    List<Counter> findByFlat(Flat flat);
}
