package com.andrew.housing.services;

import com.andrew.housing.DTO.OwnerDto;
import com.andrew.housing.dao.FlatDAO;
import com.andrew.housing.dao.OwnerDAO;
import com.andrew.housing.entity.Flat;
import com.andrew.housing.entity.Owner;
import com.andrew.housing.repositories.FlatRepository;
import com.andrew.housing.repositories.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service

public class OwnerService {
    private final OwnerDAO ownerDAO;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository, FlatRepository flatRepository){
        ownerDAO = new OwnerDAO(ownerRepository, flatRepository);
    }

    public List<Owner> findAll(){
        return ownerDAO.findAll();
    }

    public void addOwner(Owner owner){
        ownerDAO.save(owner);
    }

    public void deleteOwner(Integer id){
        ownerDAO.delete(id);
    }

    public void updateOwner(Integer id, Owner owner){
        ownerDAO.update(id, owner);
    }

    public Owner findByPassport(String passport){
        return ownerDAO.findByPassport(passport);
    }

    public Owner findById(Integer id) {
        return ownerDAO.findById(id);
    }

    public List<Owner> findByFlat(Flat flat){
        return ownerDAO.findByFLats(flat);
    }

    public Owner addFlatToOwner (Integer idOwner, Integer idFlat){
        return ownerDAO.addFlatToOwner(idOwner, idFlat);
    }

    public OwnerDto getOwnerWithFlat(Integer id){
        return ownerDAO.getOwnerWithFlats(id);
    }
}
