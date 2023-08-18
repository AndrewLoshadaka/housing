package com.andrew.housing.controllers;

import com.andrew.housing.DTO.AddReadingRequest;
import com.andrew.housing.DTO.CounterDTO;
import com.andrew.housing.DTO.FlatDto;
import com.andrew.housing.DTO.ReadingDto;
import com.andrew.housing.entity.*;
import com.andrew.housing.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/housing/flat")
public class FlatController {
    private final FlatService flatService;
    private final OwnerService ownerService;
    private final CounterService counterService;
    private final TypeService typeService;
    private final ReadingService readingService;

    @GetMapping("/all")
    public List<Flat> getAllFlats(){
        return flatService.findAll();
    }

    @PostMapping
    public ResponseEntity<String> addFlat(@RequestBody FlatDto flatDto, @RequestParam("id") Integer id){
        Flat flat = flatDto.toEntity();
        Flat addedFlat = flatService.addFlat(flat, id);
        if (addedFlat != null) {
            return ResponseEntity.ok("{\"message\": \"ok!\"}");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<String> updateFlat(
            @RequestParam("id") Integer id,
            @RequestBody Flat flat){
        try{
            flatService.updateFlat(id, flat);
            return ResponseEntity.ok("{\"message\": \"ok!\"}");
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteFlat(
            @RequestBody Map<String, Integer> map){
        try{
            flatService.deleteFlat(map.get("id"));
            return ResponseEntity.ok("{\"message\": \"ok!\"}");
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/flat_by_id")
    public Flat findFlat(
            @RequestBody Map<String, Integer> map) {
        return flatService.findById(map.get("id"));
    }

    @PostMapping("/owners")
    public List<Owner> getOwners(
            @RequestBody Map<String, Integer> map){
        Flat flat = flatService.findById(map.get("id"));
        return ownerService.findByFlat(flat);
    }

    @PostMapping("/counters")
    public List<CounterDTO> getCounters(
            @RequestBody Map<String, Integer> map){
        Flat flat = flatService.findById(map.get("id"));
        return counterService.findByFlat(flat);
    }

    @PostMapping("/addReading")
    public ResponseEntity<String> addReading(@RequestBody AddReadingRequest addReadingRequest) {
        try {
            Flat flat = flatService.findById(addReadingRequest.getFlatId());
            Type type = typeService.findById(addReadingRequest.getTypeId());
            Counter counter = counterService.findByFlatAndType(flat, type);
            Reading newReading = new Reading();
            newReading.setCounter(counter);
            newReading.setDate(addReadingRequest.getDate());
            newReading.setValue(addReadingRequest.getValue());

            readingService.save(newReading);

            return ResponseEntity.ok("Reading added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding reading");
        }
    }

    @GetMapping("/flatWithReading")
    public List<Flat> getAllFlatsWithCountersAndReadings() {
        return flatService.findAllWithCountersAndReadings();
    }
}
