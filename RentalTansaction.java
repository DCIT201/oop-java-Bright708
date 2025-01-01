
package VehicleRental;

import java.util.Objects;

public class RentalTransaction {
    private String transactionId;
    private String customerId;
    private String vehicleId;
    private int rentalDays;
    private double cost;

    // Constructor
    public RentalTransaction(String transactionId, String customerId, String vehicleId, int rentalDays, double cost) {
        if (transactionId == null || transactionId.isEmpty()) {
            throw new IllegalArgumentException("Transaction ID cannot be null or empty.");
        }
        if (customerId == null || customerId.isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty.");
        }
        if (vehicleId == null || vehicleId.isEmpty()) {
            throw new IllegalArgumentException("Vehicle ID cannot be null or empty.");
        }
        if (rentalDays <= 0) {
            throw new IllegalArgumentException("Rental days must be greater than zero.");
        }
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative.");
        }

        this.transactionId = transactionId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.rentalDays = rentalDays;
        this.cost = cost;
    }

    // Getters
    public String getTransactionId() {
        return transactionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double getCost() {
        return cost;
    }

    // Override toString for a readable representation
    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
                ", Customer ID: " + customerId +
                ", Vehicle ID: " + vehicleId +
                ", Days: " + rentalDays +
                ", Cost: " + cost;
    }

    // Override equals for object comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // If comparing the same object
        if (o == null || getClass() != o.getClass()) return false; // Null or different class
        RentalTransaction that = (RentalTransaction) o;
        return rentalDays == that.rentalDays &&
                Double.compare(that.cost, cost) == 0 &&
                Objects.equals(transactionId, that.transactionId) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(vehicleId, that.vehicleId);
    }

    // Override hashCode for consistency with equals
    @Override
    public int hashCode() {
        return Objects.hash(transactionId, customerId, vehicleId, rentalDays, cost);
    }
}
