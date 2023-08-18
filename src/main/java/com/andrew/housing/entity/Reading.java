package com.andrew.housing.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "reading")
@Getter
@Setter
@NoArgsConstructor
public class Reading {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_counter")
    @JsonIgnore
    private Counter counter;

    private double value;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
