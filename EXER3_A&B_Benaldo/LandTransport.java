public class LandTransport extends Transportation {
    protected int wheels;

    public LandTransport(String fuelType, int passengers, double speed, int wheels) {
        super(fuelType, passengers, speed);
        this.wheels = wheels;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Wheels: " + wheels);
    }
}