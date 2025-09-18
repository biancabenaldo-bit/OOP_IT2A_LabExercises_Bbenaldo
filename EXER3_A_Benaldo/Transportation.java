public class Transportation {
    protected String fuelType;
    protected int passengers;
    protected double speed;

    public Transportation(String fuelType, int passengers, double speed) {
        this.fuelType = fuelType;
        this.passengers = passengers;
        this.speed = speed;
    }

    public void startEngine() {
        System.out.println("The vehicle's engine is starting.");
    }

    public void stopEngine() {
        System.out.println("The vehicle's engine is stopping.");
    }

    public void displayInfo() {
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Passengers: " + passengers);
        System.out.println("Speed: " + speed + " km/h");
    }
}