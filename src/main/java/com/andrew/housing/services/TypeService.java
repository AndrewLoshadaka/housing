package com.andrew.housing.services;

import com.andrew.housing.entity.Type;
import com.andrew.housing.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Type findById(Integer id){
        return typeRepository.findById(id).orElse(null);
    }
}
