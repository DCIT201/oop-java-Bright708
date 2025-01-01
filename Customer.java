
package VehicleRental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// Customer Class
public class Customer {
    private String customerId;
    private String name;
    private List<String> rentedVehicles;
    //Constructor
    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        rentedVehicles = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void addRental(String vehicleId) {
        rentedVehicles.add(vehicleId);
    }


    public List<String> getRentalHistory() {
        return Collections.unmodifiableList(rentedVehicles);
    }

    public void clearRentalHistory() {
        rentedVehicles.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }
}

