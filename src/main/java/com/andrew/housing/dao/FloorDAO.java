package com.andrew.housing.dao;

import com.andrew.housing.DTO.FlatDto;
import com.andrew.housing.entity.Floor;
import com.andrew.housing.repositories.FloorRepository;

import java.util.List;

public class FloorDAO {
    private final FloorRepository repository;

    public FloorDAO(FloorRepository repository) {
        this.repository = repository;
    }

    public Floor getFloorById(Integer floorId) {
        return repository.findById(floorId).orElse(null);
    }

}
