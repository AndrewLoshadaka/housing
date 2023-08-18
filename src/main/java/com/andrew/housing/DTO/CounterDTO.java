package com.andrew.housing.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public @Setter
@Getter
@NoArgsConstructor
class CounterDTO{
    private long flatId;
    private int counterId;
    private String counterType;
    private List<ReadingDto> readings;
}