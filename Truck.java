
package VehicleRental;

public class Truck extends Vehicle implements Rentable {
    public Truck(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        super(vehicleId, model, baseRentalRate, isAvailable);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * 2.5; // 25% additional cost
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false);
            customer.addRental(getVehicleId());
            System.out.println("Truck rented successfully to " +customer.getName()+ " for " +days+ " days");
        } else {
            System.out.println("Truck not available for rental");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Truck returned successfully");

    }
}
