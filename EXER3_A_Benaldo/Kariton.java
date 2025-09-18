public class Kariton extends LandTransport {
    public Kariton(String fuelType, int passengers, double speed, int wheels) {
        super(fuelType, passengers, speed, wheels);
    }

    @Override
    public void startEngine() {
        System.out.println("The kariton is being pulled. No engine to start.");
    }
}