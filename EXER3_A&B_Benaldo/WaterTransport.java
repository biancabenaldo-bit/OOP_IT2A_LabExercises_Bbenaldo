public class WaterTransport extends Transportation {
    protected double buoyancy;

    public WaterTransport(String fuelType, int passengers, double speed, double buoyancy) {
        super(fuelType, passengers, speed);
        this.buoyancy = buoyancy;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Buoyancy: " + buoyancy + " N");
    }
}