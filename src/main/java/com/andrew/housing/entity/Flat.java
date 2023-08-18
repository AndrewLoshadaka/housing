package com.andrew.housing.entity;

import com.andrew.housing.DTO.FlatDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.Set;

@Entity
@Table (name = "flat")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Flat {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private double area;

    @Column(name = "floor_space")
    private double floorSpace;

    @Column(name = "room_value")
    private int roomValue;

    @Column(name = "number_flat")
    private int flatNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_floor")
    @JsonIgnore
    private Floor floor;

    @OneToMany(mappedBy = "flat", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Counter> counters;

    @ManyToMany(mappedBy = "flats")
    @JsonIgnore
    private Set<Owner> owner;

    public FlatDto toDTO() {
        return new ModelMapper().map(this, FlatDto.class);
    }
}
