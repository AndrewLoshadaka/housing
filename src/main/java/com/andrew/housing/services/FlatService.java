package com.andrew.housing.services;

import com.andrew.housing.dao.FlatDAO;
import com.andrew.housing.entity.Flat;
import com.andrew.housing.entity.Floor;
import com.andrew.housing.entity.Owner;
import com.andrew.housing.repositories.FlatRepository;
import com.andrew.housing.repositories.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlatService {
    private final FlatDAO flatDAO;

    @Autowired
    public FlatService(FlatRepository flatRepository, FloorRepository floorRepository) {
        this.flatDAO = new FlatDAO(flatRepository, floorRepository);
    }

    public List<Flat> findAll(){
        return flatDAO.findAll();
    }

    public Flat findById(Integer id){
        return flatDAO.findById(id);
    }

    public Flat addFlat(Flat flat, Integer id){
        flatDAO.addFlat(flat, id);
        return flat;
    }


    public void updateFlat(Integer id, Flat flat){
        flatDAO.update(id, flat);
    }

    public void deleteFlat(Integer id){
        flatDAO.delete(id);
    }

    public List<Flat> findFlats(Floor floor){
        return flatDAO.findFlats(floor);
    }

    public List<Flat> findFlats(Owner owner){
        return flatDAO.findFlats(owner);
    }

    public List<Flat> findAllWithCountersAndReadings(){
        return flatDAO.findAllWithCountersAndReadings();
    }
}
