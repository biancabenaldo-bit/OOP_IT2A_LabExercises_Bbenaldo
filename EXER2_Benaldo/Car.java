public class Car {
    private String color;
    private String plateNo;
    private String chassisNo;
    private String brand;
    private String origin;
    private double price; // price in PHP

    // No-argument constructor
    public Car() {
        this.color = "No Color";
        this.plateNo = "No Plate Number";
        this.chassisNo = "No Chassis Number";
        this.brand = "No Brand";
        this.origin = "No Origin";
        this.price = 0.0;
    }

    // Parameterized constructor
    public Car(String color, String plateNo, String chassisNo,
               String brand, String origin, double price) {
        this.color = color;
        this.plateNo = plateNo;
        this.chassisNo = chassisNo;
        this.brand = brand;
        this.origin = origin;
        this.price = price;
    }

    // Method to display car information
    public void displayInfo() {
        String info = "";
        info += "Brand: " + this.brand;
        info += "\nColor: " + this.color;
        info += "\nPlateNo: " + this.plateNo;
        info += "\nChassisNo: " + this.chassisNo;
        info += "\nOrigin: " + this.origin;
        info += "\nPrice: ₱" + String.format("%,.2f", this.price);

        System.out.println(info);
        System.out.println("-----------------------------");
    }
}
