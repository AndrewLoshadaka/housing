package com.andrew.housing.repositories;

import com.andrew.housing.dao.ReadingDao;
import com.andrew.housing.entity.Reading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingRepository extends JpaRepository<Reading, Integer> {

}
