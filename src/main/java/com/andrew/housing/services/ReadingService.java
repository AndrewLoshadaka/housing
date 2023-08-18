package com.andrew.housing.services;

import com.andrew.housing.dao.ReadingDao;
import com.andrew.housing.entity.Reading;
import com.andrew.housing.repositories.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadingService {
    private final ReadingDao readingDao;

    @Autowired
    public ReadingService (ReadingRepository readingRepository){
        this.readingDao = new ReadingDao(readingRepository);
    }

    public void save(Reading reading){
        readingDao.save(reading);
    }
}
