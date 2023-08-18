package com.andrew.housing.controllers;

import com.andrew.housing.DTO.OwnerDto;
import com.andrew.housing.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/housing")
@RequiredArgsConstructor
public class HomeController {

    private final OwnerService ownerService;

    @PostMapping
    public ResponseEntity<OwnerDto> getOwnerWithFlat(
            @RequestBody Map<String, Integer> map){
        OwnerDto ownerDto = ownerService.getOwnerWithFlat(map.get("id"));

        if (ownerDto != null){
            return ResponseEntity.ok(ownerDto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
