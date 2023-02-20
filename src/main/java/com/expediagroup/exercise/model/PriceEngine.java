package com.expediagroup.exercise.model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceEngine {
    static Map<Integer, Double> prices = new HashMap<>();

    public PriceEngine(final List<Hotel> hotels) {
        for (var hotel : hotels) {
            prices.put(hotel.getId(), hotel.getNightPrice());
        }
    }

    static public Double getNightPrice(final Integer hotelId) {
        return prices.get(hotelId);
    }
}
