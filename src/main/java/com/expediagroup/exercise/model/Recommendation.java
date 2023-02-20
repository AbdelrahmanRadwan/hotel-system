package com.expediagroup.exercise.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Recommendation {
    Integer hotelId;
    Double totalStayPrice;
}
