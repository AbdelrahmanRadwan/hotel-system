package com.expediagroup.exercise.model;

import lombok.Data;

import java.util.*;

@Data
public class Availability {
    static Map<Integer, Set<Integer>> availability = new HashMap<>();

    public Availability(final List<AvailabilityRecord> initialAvailabilities){
        initialAvailabilities.forEach(this::appendAvailability);
    }

    public void appendAvailability(final AvailabilityRecord availabilityRecord) {
        Integer hotelId = availabilityRecord.getHotelId();
        for(var day: availabilityRecord.getAvailabilityDays()) {
            Set<Integer> availabilityDays = availability.computeIfAbsent(day, k -> new HashSet<>());
            availabilityDays.add(hotelId);
        }
    }
    public Set<Integer> getAvailability(final Integer day) {
        return availability.getOrDefault(day, Set.of());
    }
}
