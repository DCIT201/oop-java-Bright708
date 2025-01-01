
package VehicleRental;

public class Car extends Vehicle implements Rentable{
    public Car(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        super(vehicleId, model, baseRentalRate, isAvailable);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * 1.5; // 15% of additional cost
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if(isAvailableForRental()) {
            setAvailable(false);
            customer.addRental(getVehicleId());
            System.out.println("Car rented successfully to "+ customer.getName() +" for " +days+ " days");
        }

    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Car returned successfully");

    }
}
