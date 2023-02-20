package com.expediagroup.exercise.service;

import com.expediagroup.exercise.model.Availability;
import com.expediagroup.exercise.model.PriceEngine;
import com.expediagroup.exercise.model.Recommendation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecommendationService {

    private static RecommendationService instance;
    private final Availability availability;

    public RecommendationService(final Availability initialAvailabilities, final PriceEngine initialPriceEngine) {
        availability = initialAvailabilities;
    }

    public static synchronized RecommendationService getInstance(final Availability initialAvailabilities, final PriceEngine initialPriceEngine) {
        if (instance == null) {
            instance = new RecommendationService(initialAvailabilities, initialPriceEngine);
        }
        return instance;
    }

    private List<Recommendation> enrichRecommendationsWithTotalPrice(final Set<Integer> recommendationIds, final Integer stayAmount) {
        List<Recommendation> recommendations = new ArrayList<>();
        for (var hotelId : recommendationIds) {
            Double stayPrice = stayAmount * PriceEngine.getNightPrice(hotelId);
            recommendations.add(new Recommendation(hotelId, stayPrice));
        }
        return recommendations;
    }

    public List<Recommendation> getRecommendations(final Integer stayStartDay, final Integer stayAmount) {
        int lastStayDay = stayStartDay + stayAmount - 1;
        Set<Integer> recommendationsHotelIdsSoFar = availability.getAvailability(stayStartDay);
        for (int day = stayStartDay + 1; day <= lastStayDay; day++) {
            Set<Integer> availableHotelIdsForDay = availability.getAvailability(day);
            recommendationsHotelIdsSoFar.retainAll(availableHotelIdsForDay);
        }
        return enrichRecommendationsWithTotalPrice(new HashSet<>(recommendationsHotelIdsSoFar), stayAmount);
    }
}
