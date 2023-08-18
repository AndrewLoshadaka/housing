package com.andrew.housing.services;

import com.andrew.housing.DTO.CounterDTO;
import com.andrew.housing.dao.CounterDAO;
import com.andrew.housing.entity.Counter;
import com.andrew.housing.entity.Flat;
import com.andrew.housing.entity.Type;
import com.andrew.housing.repositories.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterService {
    private final CounterDAO counterDAO;

    @Autowired
    public CounterService(CounterRepository counterRepository) {
        this.counterDAO = new CounterDAO(counterRepository);
    }

    //все счетчики для квартиры
    public List<CounterDTO> findByFlat(Flat flat) {
        return counterDAO.getCountersForFlat(flat);
    }

    public Counter findByFlatAndType(Flat flat, Type type){
        return counterDAO.findByFlatAndType(flat, type);
    }
}
