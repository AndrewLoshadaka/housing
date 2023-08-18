package com.andrew.housing.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Set;

@Entity
@Table (name = "floor")
@Getter
@Setter
@NoArgsConstructor
public class Floor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "flat_value")
    private int flatValue;

    @Column(name = "number_floor")
    private int floorNumber;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flat> flats;

    public FloorDto toDTO() {
        return new ModelMapper().map(this, FloorDto.class);
    }
 }


 @Getter
 @Setter
 @NoArgsConstructor
 class FloorDto{
     private long id;
     private int flatValue;
     private int floorNumber;
 }
