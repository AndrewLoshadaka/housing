package com.andrew.housing.DTO;

import com.andrew.housing.entity.Flat;
import com.andrew.housing.entity.Owner;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OwnerDto {
    private Owner owner;
    private List<Flat> flats;
}
