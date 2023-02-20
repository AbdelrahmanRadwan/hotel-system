package com.expediagroup.exercise.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AvailabilityRecord {
    Integer hotelId;
    List<Integer> availabilityDays;
}
