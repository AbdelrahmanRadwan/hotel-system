package com.expediagroup.exercise;

import com.expediagroup.exercise.model.*;
import com.expediagroup.exercise.service.RecommendationService;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel(0, "Awesome Hotel", 95.00));
        hotels.add(new Hotel(1, "Another Awesome Hotel", 52.50));
        hotels.add(new Hotel(2, "One more Awesome Hotel", 63.50));
        hotels.add(new Hotel(3, "Awesome Hotel D", 22.10));

        PriceEngine priceEngine = new PriceEngine(hotels);

        List<AvailabilityRecord> availabilityRecords = new ArrayList<>();
        availabilityRecords.add(new AvailabilityRecord(0, List.of(0, 1)));
        availabilityRecords.add(new AvailabilityRecord(1, List.of(1, 2)));
        availabilityRecords.add(new AvailabilityRecord(2, List.of(0, 1, 2)));
        Availability availability = new Availability(availabilityRecords);

        RecommendationService recommendationService = new RecommendationService(availability, priceEngine);
        System.out.println(recommendationService.getRecommendations(1, 2));

    }
}
