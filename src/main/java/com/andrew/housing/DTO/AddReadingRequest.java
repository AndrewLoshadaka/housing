package com.andrew.housing.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class AddReadingRequest {
    private Integer flatId;
    private Integer typeId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private double value;
}
