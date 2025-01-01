
package VehicleRental;

public class Motorcycle extends Vehicle implements Rentable{
    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        super(vehicleId, model, baseRentalRate, isAvailable);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * 0.5;// 5% additional cost
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
            System.out.println("Motorcycle rented successfully to " + customer.getName() + " for " + days + " days");
        } else {
            System.out.println("Motorcycle not available for rental");
        }

    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Motorcycle returned successfully");

    }
}
