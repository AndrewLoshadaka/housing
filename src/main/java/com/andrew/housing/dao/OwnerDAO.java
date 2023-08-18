package com.andrew.housing.dao;

import com.andrew.housing.DTO.OwnerDto;
import com.andrew.housing.entity.Flat;
import com.andrew.housing.entity.Owner;
import com.andrew.housing.repositories.FlatRepository;
import com.andrew.housing.repositories.OwnerRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public class OwnerDAO {
    private final OwnerRepository ownerRepository;
    private final FlatRepository flatRepository;
    public OwnerDAO(OwnerRepository ownerRepository, FlatRepository flatRepository){
        this.ownerRepository = ownerRepository;
        this.flatRepository = flatRepository;
    }

    public Owner addFlatToOwner(Integer idOwner, Integer idFlat){
        Owner owner = ownerRepository.findById(idOwner).orElse(null);
        Flat flat = flatRepository.findById(idFlat).orElse(null);

        if(owner != null && flat != null){
            owner.getFlats().add(flat);
            flat.getOwner().add(owner);
            ownerRepository.save(owner);
            flatRepository.save(flat);
            return owner;
        }
        return null;
    }

    /**
     * возможно было бы лучше использовать тут OwnerFlatInfoDto
     * @param id
     * @return
     */
    public OwnerDto getOwnerWithFlats(Integer id){
        Owner owner = ownerRepository.findById(id).orElse(null);
        if(owner != null){
            OwnerDto ownerDto = new OwnerDto();
            ownerDto.setOwner(owner);
            ownerDto.setFlats(owner.getFlats());
            return ownerDto;
        }
        return null;
    }

    public List<Owner> findAll(){
        return ownerRepository.findAll();
    }

    @Transactional
    public void save(Owner owner){
        ownerRepository.save(owner);
    }

    @Transactional
    public void update(Integer id, Owner owner){
        Owner oldOwner = ownerRepository.findById(id).orElse(null);
        if(oldOwner != null){
            owner.setFlats(oldOwner.getFlats());
        }

        owner.setId(id);
        ownerRepository.save(owner);
    }

    @Transactional
    public void delete(Integer id){
        ownerRepository.deleteById(id);
    }

    public Owner findById(Integer id){
        Optional<Owner> owner = ownerRepository.findById(id);
        return owner.orElse(null);
    }

    public Owner findByPassport(String passport){
        Optional<Owner> owner = ownerRepository.findByPassport(passport);
        return owner.orElse(null);
    }

    public List<Owner> findByFLats(Flat flat){
        return ownerRepository.findByFlats(flat);
    }
}
