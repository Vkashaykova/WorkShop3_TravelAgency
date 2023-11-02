package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;

public class AirplaneImpl extends VehiclesImpl implements Airplane {

    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    private final boolean hasFreeFood;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.AIR);
        this.hasFreeFood = hasFreeFood;

    }

    @Override
    public boolean hasFreeFood() {

        return true;
    }

    @Override
    public String getAsString() {
        return String.format("Airplane ----%n%sHas free food: %s%n", super.getAsString(), this.hasFreeFood);
    }
}