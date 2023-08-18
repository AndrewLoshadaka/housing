package com.andrew.housing.repositories;

import com.andrew.housing.DTO.FlatDto;
import com.andrew.housing.entity.Floor;
import com.andrew.housing.services.FloorService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FloorRepository extends JpaRepository<Floor, Integer> {

}
