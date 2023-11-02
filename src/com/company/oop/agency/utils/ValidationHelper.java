package com.company.oop.agency.utils;

import com.company.oop.agency.exceptions.InvalidUserInputException;

import java.util.List;

public class ValidationHelper {

    public static final String INVALID_NUMBER_OF_ARGUMENTS = "Invalid number of arguments. Expected: %d, Received: %d";

    private static final String PASSENGERS_CAPACITY = "%s cannot have less than %d passengers or more than %d passengers.";
    private static final String CARTS_CAPACITY = "%s cannot have less than %d cart or more than %d carts.";
    public static final String VEHICLE_PRICE_PER_KILOMETER = "%s with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!";
    public static final String ADDITIONAL_VALIDATION_FOR_CAPACITY = "%s with less than %d passenger or more than %d passengers cannot exist!";

    public static final String STRING_LENGTH_ERROR = "%s length cannot be less than %d or more than %d symbols long.";
    public static final String INVALID_DISTANCE = "The Distance cannot be less than %d or more than %d kilometers.";

    public static void validateValueInRange(int value, int min, int max, String errorMessage) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(String.format(STRING_LENGTH_ERROR, errorMessage, min, max));
        }
    }

    public static void validateStringLength(String stringToValidate, int minLength, int maxLength, String errorMessage) {
        validateValueInRange(stringToValidate.length(), minLength, maxLength, errorMessage);
    }

    public static void validateArgumentsCount(List<String> list, int expectedArgumentsCount) {
        if (list.size() < expectedArgumentsCount || list.size() > expectedArgumentsCount) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS, expectedArgumentsCount, list.size()));
        }


    } public static void validateNumberValue(double quantity,double min, double max, String type) {
        if (quantity < min|| quantity>max) {
            throw new IllegalArgumentException(String.format(VEHICLE_PRICE_PER_KILOMETER,type,min,max));
        }
    } public static void validateCapacity(int value, int min, int max, String errorMessage) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(String.format(PASSENGERS_CAPACITY, errorMessage, min, max));
        }
    }
    public static void additionalValidationCapacity(int value,int min,int max, String errorMessage) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(String.format(ADDITIONAL_VALIDATION_FOR_CAPACITY, errorMessage,min,max));
        }
    }
    public static void validateCarts(int value, int min, int max, String type) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(String.format(CARTS_CAPACITY, type, min, max));
        }

    }public static void validateDistance(int value, int min, int max) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(String.format(INVALID_DISTANCE,min,max));
        }

    }

}