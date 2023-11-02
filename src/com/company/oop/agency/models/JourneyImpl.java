package com.company.oop.agency.models;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ValidationHelper;

public class JourneyImpl implements Journey {

    public static final int START_LOCATION_MIN_LENGTH = 5;
    public static final int START_LOCATION_MAX_LENGTH = 25;
    public static final int DESTINATION_MIN_LENGTH = 5;
    public static final int DESTINATION_MAX_LENGTH = 25;
    public static final int DISTANCE_MIN_VALUE = 5;
    public static final int DISTANCE_MAX_VALUE = 5000;
    private int id;
    private String startLocation;
    private String destination;
    private int distance;
    private Vehicle vehicle;


    public JourneyImpl(int id, String startLocation, String destination, int distance, Vehicle vehicle) {
        setStartLocation(startLocation);
        setDestination(destination);
        setDistance(distance);
        setVehicle(vehicle);
        this.id = id;
    }

    private void setStartLocation(String startLocation) {
        ValidationHelper.validateStringLength(startLocation, START_LOCATION_MIN_LENGTH, START_LOCATION_MAX_LENGTH, "The StartingLocation's");
        this.startLocation = startLocation;
    }

    private void setDestination(String destination) {
        ValidationHelper.validateStringLength(destination, DESTINATION_MIN_LENGTH, DESTINATION_MAX_LENGTH, "The Destination's");
        this.destination = destination;
    }

    private void setDistance(int distance) {
        ValidationHelper.validateDistance(distance, DISTANCE_MIN_VALUE, DISTANCE_MAX_VALUE);
        this.distance = distance;
    }

    private void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String getStartLocation() {
        return startLocation;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public double calculateTravelCosts() {
        return getDistance() * getVehicle().getPricePerKilometer();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return String.format("Journey ----\n" +
                "Start location: %s\n" +
                "Destination: %s\n" +
                "Distance: %d\n" +
                "Vehicle type: %s\n" +
                "Travel costs: %.2f%n", startLocation, destination, distance, vehicle.getType(), calculateTravelCosts());
    }


}