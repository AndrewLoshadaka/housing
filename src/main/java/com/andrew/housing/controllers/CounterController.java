package com.andrew.housing.controllers;

import com.andrew.housing.entity.Counter;
import com.andrew.housing.DTO.CounterDTO;
import com.andrew.housing.entity.Flat;
import com.andrew.housing.services.CounterService;
import com.andrew.housing.services.FlatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/housing/counter")
@RequiredArgsConstructor
public class CounterController {
    private final CounterService counterService;
    private final FlatService flatService;

}
