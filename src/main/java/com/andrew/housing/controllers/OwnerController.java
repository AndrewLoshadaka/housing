package com.andrew.housing.controllers;


import com.andrew.housing.entity.Flat;
import com.andrew.housing.entity.Owner;
import com.andrew.housing.services.FlatService;
import com.andrew.housing.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/housing/owners")
@CrossOrigin(origins = "http://localhost:4200") // ???????????????
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;
    private final FlatService flatService;

    @GetMapping("/all")
    public List<Owner> getOwner(){
        return ownerService.findAll();
    }

    @PostMapping
    public ResponseEntity<String> addOwner(
            @RequestBody Owner owner){
        try{
            ownerService.addOwner(owner);
            return ResponseEntity.ok("{\"message\": \"ok!\"}");
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteOwner(
            @RequestBody Map<String, Integer> map) {
        try{
            ownerService.deleteOwner(map.get("id"));
            return ResponseEntity.ok("{\"message\": \"ok!\"}");
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<String> updateOwner(
            @RequestParam("id") Integer id,
            @RequestBody Owner owner){
        try{
            ownerService.updateOwner(id, owner);
            return ResponseEntity.ok("{\"message\": \"ok!\"}");
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/find_by_passport")
    public Owner findOwner(
            @RequestBody Map<String, String> map){
        return ownerService.findByPassport(map.get("passport"));
    }

    @PostMapping("/flats")
    public List<Flat> getListFlats(
            @RequestBody Map<String, Integer> map){
        Owner owner = ownerService.findById(map.get("id"));
        return flatService.findFlats(owner);
    }

    @PostMapping("/addFlatToOwner")
    public ResponseEntity<String> addFlatToOwner(
            @RequestBody Map<String, Integer> map){
        Owner owner = ownerService.addFlatToOwner(map.get("ownerId"), map.get("flatId"));
        if (owner != null) {
            return ResponseEntity.ok("Owner added to flat successfully.");
        } else {
            return ResponseEntity.badRequest().body("Flat or owner not found.");
        }
    }
}
