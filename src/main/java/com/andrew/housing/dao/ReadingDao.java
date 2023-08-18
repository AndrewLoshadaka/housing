package com.andrew.housing.dao;

import com.andrew.housing.entity.Reading;
import com.andrew.housing.repositories.ReadingRepository;
import jakarta.transaction.Transactional;

public class ReadingDao {
    private final ReadingRepository readingRepository;

    public ReadingDao(ReadingRepository readingRepository) {
        this.readingRepository = readingRepository;
    }

    @Transactional
    public void save(Reading reading){
        readingRepository.save(reading);
    }
}
