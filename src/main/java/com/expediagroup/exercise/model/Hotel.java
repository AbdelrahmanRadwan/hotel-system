package com.expediagroup.exercise.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Hotel {
    Integer id;
    String hotelName;
    Double nightPrice;
}
