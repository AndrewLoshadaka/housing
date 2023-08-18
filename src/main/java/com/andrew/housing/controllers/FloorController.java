package com.andrew.housing.controllers;

import com.andrew.housing.DTO.FlatDto;
import com.andrew.housing.entity.Flat;
import com.andrew.housing.entity.Floor;
import com.andrew.housing.services.FlatService;
import com.andrew.housing.services.FloorService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/housing/floor")
@RequiredArgsConstructor
public class FloorController {
    private final FloorService floorService;
    private final FlatService flatService;

    @GetMapping("/flats")
    public List<Flat> getFlatsByFloorId(@RequestParam(name = "id") Integer id, Model model) {
        Floor floor = floorService.findOneById(id);
        List<Flat> flats = flatService.findFlats(floor);
        model.addAttribute("floor", floor);
        if(!flats.isEmpty())
            model.addAttribute("flats", flats);
        return flats;
    }
}
