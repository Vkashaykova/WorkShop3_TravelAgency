package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {

    public static final String INVALID_COST = "Value of 'costs' must be a positive number. Actual value: %.2f.";
    private int id;
    private Journey journey;
    private double costs;

    public TicketImpl(int id, Journey journey, double costs) {
        setJourney(journey);
        setCost(costs);
        this.id = id;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setJourney(Journey journey) {
        this.journey = journey;
    }

    private double getCost() {
        return costs;
    }

    private void setCost(double costs) {
        if (costs < 0) {
            throw new InvalidUserInputException(String.format(INVALID_COST, costs));
        }

        this.costs = costs;

    }

    @Override
    public Journey getJourney() {
        return this.journey;
    }

    @Override
    public double calculatePrice() {
        return getAdministrativeCosts() * getJourney().calculateTravelCosts();
    }

    @Override
    public double getAdministrativeCosts() {
        return costs;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return String.format("Ticket ----%n" +
                "Destination: %s%n" +
                "Price: %.2f%n", journey.getDestination(), calculatePrice());
    }
}
