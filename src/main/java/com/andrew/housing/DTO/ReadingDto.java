package com.andrew.housing.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ReadingDto {
    private int idReading;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private double value;
}
