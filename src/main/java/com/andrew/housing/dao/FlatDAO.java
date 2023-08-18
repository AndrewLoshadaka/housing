package com.andrew.housing.dao;

import com.andrew.housing.entity.Flat;
import com.andrew.housing.entity.Floor;
import com.andrew.housing.entity.Owner;
import com.andrew.housing.repositories.FlatRepository;
import com.andrew.housing.repositories.FloorRepository;
import jakarta.transaction.Transactional;



import java.util.List;

public class FlatDAO {
    private final FlatRepository flatRepository;
    private final FloorRepository floorRepository;

    public FlatDAO(FlatRepository flatRepository, FloorRepository floorRepository) {
        this.flatRepository = flatRepository;
        this.floorRepository = floorRepository;
    }

    @Transactional
    public List<Flat> findAll(){
        return flatRepository.findAll();
    }

    public Flat addFlat(Flat flat, Integer floorId){
        Floor floor = floorRepository.findById(floorId).orElse(null);
        if(floor != null){
            flat.setFloor(floor);
            return flatRepository.save(flat);
        }

        return null;
    }

    @Transactional
    public void save(Flat flat){
        flatRepository.save(flat);
    }

    @Transactional
    public void update(Integer id, Flat flat){
        Flat oldFlat = flatRepository.findById(id).orElse(null);
        if(oldFlat != null)
            flat.setOwner(oldFlat.getOwner());

        flat.setId(id);
        flatRepository.save(flat);
    }

    @Transactional
    public void delete(Integer id){
        flatRepository.deleteById(id);
    }

    public Flat findById(Integer id){
        return flatRepository.findById(id).orElse(null);
    }

    public List<Flat> findFlats(Floor floor){
        return flatRepository.findByFloor(floor);
    }

    public List<Flat> findFlats(Owner owner){
        return flatRepository.findByOwner(owner);
    }

    public List<Flat> findAllWithCountersAndReadings(){
        return flatRepository.findAllWithCountersAndReadings();
    }

}
