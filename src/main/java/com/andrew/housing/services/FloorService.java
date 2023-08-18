package com.andrew.housing.services;

import com.andrew.housing.DTO.FlatDto;
import com.andrew.housing.dao.FlatDAO;
import com.andrew.housing.dao.FloorDAO;
import com.andrew.housing.entity.Flat;
import com.andrew.housing.entity.Floor;
import com.andrew.housing.repositories.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FloorService {
    private final FloorDAO floorDAO;

    @Autowired
    public FloorService(FloorRepository repository) {
        this.floorDAO = new FloorDAO(repository);
    }

    public Floor findOneById(Integer id){
        return floorDAO.getFloorById(id);
    }
}
