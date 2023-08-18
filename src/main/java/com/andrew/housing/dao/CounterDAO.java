package com.andrew.housing.dao;

import com.andrew.housing.DTO.CounterDTO;
import com.andrew.housing.DTO.ReadingDto;
import com.andrew.housing.entity.Counter;
import com.andrew.housing.entity.Flat;
import com.andrew.housing.entity.Reading;
import com.andrew.housing.entity.Type;
import com.andrew.housing.repositories.CounterRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CounterDAO {
    private final CounterRepository counterRepository;

    public CounterDAO(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    public List<CounterDTO> getCountersForFlat(Flat flat) {
        List<Counter> counters = counterRepository.findByFlat(flat);

        return counters.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Counter findByFlatAndType(Flat flat, Type type){
        return counterRepository.findByFlatAndType(flat, type);
    }

    private CounterDTO mapToDTO(Counter counter) {
        CounterDTO dto = new CounterDTO();
        dto.setFlatId(counter.getFlat().getId());
        dto.setCounterType(counter.getType().getName());

        List<ReadingDto> readingDTOs = counter.getReadings().stream()
                .map(this::mapToReadingDTO)
                .collect(Collectors.toList());
        dto.setReadings(readingDTOs);

        return dto;
    }

    private ReadingDto mapToReadingDTO(Reading reading) {
        ReadingDto dto = new ReadingDto();
        dto.setDate(reading.getDate());
        dto.setValue(reading.getValue());
        return dto;
    }
}
