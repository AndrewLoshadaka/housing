package com.andrew.housing.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "counter")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Counter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "counter", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Reading> readings;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type")
    @JsonIgnore
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_flat")
    @JsonIgnore
    private Flat flat;
}



