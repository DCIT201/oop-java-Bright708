package VehicleRental;


//Abstract Vehicle Class
public abstract class Vehicle {
    private String vehicleId;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;

    public Vehicle(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        if (vehicleId == null || vehicleId.isEmpty()) throw new IllegalArgumentException("Vehicle id cannot be null or empty");
        if (model == null || model.isEmpty()) throw new IllegalArgumentException("Vehicle model cannot be null or empty");
        if (baseRentalRate <= 0) throw new IllegalArgumentException("Base Rental rate must be positive");

        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = true;
    }
    //Getters and Setters for the individual fields
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public void setBaseRentalRate(double baseRentalRate) {
        this.baseRentalRate = baseRentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public abstract double calculateRentalCost(int days);
    public abstract boolean isAvailableForRental();

    @Override
    public String toString() {
        return "Vehicle ID: " +vehicleId+
                ", Model: " +model+
                ", Base Rental Rate: " +baseRentalRate+
                ", Available: " +isAvailable;

    }
}
