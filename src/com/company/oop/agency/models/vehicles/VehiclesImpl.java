package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ValidationHelper;

public abstract class VehiclesImpl implements Vehicle {

    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;
    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;

    private int id;
    private int passengerCapacity;
    private double pricePerKilometer;
    private VehicleType type;

    public VehiclesImpl(int id, int passengerCapacity, double pricePerKilometer, VehicleType type) {
        setId(id);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
        this.type = type;


    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private void setPassengerCapacity(int passengerCapacity) {
        ValidationHelper.additionalValidationCapacity(passengerCapacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE, "A vehicle");

        this.passengerCapacity = passengerCapacity;
    }

    private void setPricePerKilometer(double pricePerKilometer) {
        ValidationHelper.validateNumberValue(pricePerKilometer, PRICE_MIN_VALUE, PRICE_MAX_VALUE, "A vehicle");

        this.pricePerKilometer = pricePerKilometer;
    }

    private void setType(VehicleType type) {
        this.type = type;
    }

    @Override
    public VehicleType getType() {
        return this.type;
    }

    @Override
    public int getPassengerCapacity() {
        return this.passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return this.pricePerKilometer;
    }


    public String getAsString() {
        return String.format("Passenger capacity: %d%n" +
                "Price per kilometer: %.2f%n" +
                "Vehicle type: %s%n", this.passengerCapacity, this.pricePerKilometer, this.type);
    }
}
