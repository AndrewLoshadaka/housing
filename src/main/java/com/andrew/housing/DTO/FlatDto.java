package com.andrew.housing.DTO;

import com.andrew.housing.entity.Counter;
import com.andrew.housing.entity.Flat;
import com.andrew.housing.entity.Floor;
import com.andrew.housing.entity.Owner;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class FlatDto {
    private int idFlat;
    private int flatNumber;
    private double area;
    private double floorSpace;
    private int roomValue;

    private List<CounterDTO> counters;



    public Flat toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Flat.class);
    }
}
