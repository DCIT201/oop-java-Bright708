
package VehicleRental;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RentalAgency {
    private final List<Vehicle> vehicleFleet;

    public RentalAgency() {
        vehicleFleet = new ArrayList<>();
    }


    public void addVehicle(Vehicle vehicle) {
        vehicleFleet.add(vehicle);
    }

    public Vehicle findAvailableVehicle(String model) {
        for (Vehicle vehicle : vehicleFleet) {
            if (vehicle.isAvailable() && vehicle.getModel().equalsIgnoreCase(model)) {
                return vehicle;
            }
        }
        return null;
    }

    public void handleRental(Customer customer, String model, int days) {
        Vehicle vehicle = findAvailableVehicle(model);
        if (vehicle instanceof Rentable) {
            ((Rentable) vehicle).rent(customer, days);
        } else {
            System.out.println("No available vehicle of the specified model.");
        }
    }

    public void returnVehicle(String vehicleId) {
        for (Vehicle vehicle : vehicleFleet) {
            if (vehicle.getVehicleId().equals(vehicleId) && vehicle instanceof Rentable) {
                ((Rentable) vehicle).returnVehicle();
                return;
            }
        }
        System.out.println("Vehicle ID not found.");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalAgency that = (RentalAgency) o;
        return Objects.equals(vehicleFleet, that.vehicleFleet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleFleet);
    }
}
