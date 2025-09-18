public class AirTransport extends Transportation {
    protected int altitude;

    public AirTransport(String fuelType, int passengers, double speed, int altitude) {
        super(fuelType, passengers, speed);
        this.altitude = altitude;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Altitude: " + altitude + " feet");
    }
}