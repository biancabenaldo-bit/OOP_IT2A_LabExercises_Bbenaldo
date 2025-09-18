public class TransportationTester {
    public static void main(String[] args) {
        
        Helicopter myHelicopter = new Helicopter("Jet Fuel", 4, 250, 10000);
        Airplane myAirplane = new Airplane("Jet Fuel", 200, 900, 35000);
        SpaceShuttle mySpaceShuttle = new SpaceShuttle("Liquid Hydrogen", 7, 28000, 100000);

        
        Truck myTruck = new Truck("Diesel", 3, 100, 6);
        SUV mySUV = new SUV("Gasoline", 5, 120, 4);
        Tricycle myTricycle = new Tricycle("Gasoline", 3, 50, 3);
        Motorcycle myMotorcycle = new Motorcycle("Gasoline", 2, 150, 2);
        Kariton myKariton = new Kariton("Human Power", 1, 5, 2);

       
        Boat myBoat = new Boat("Diesel", 10, 50, 150000);
        Ship myShip = new Ship("Bunker Fuel", 500, 40, 500000);

        
        System.out.println("===== Helicopter Information =====");
        myHelicopter.displayInfo();
        myHelicopter.startEngine();
        System.out.println();

        System.out.println("===== Airplane Information =====");
        myAirplane.displayInfo();
        myAirplane.startEngine();
        System.out.println();

        System.out.println("--- Space Shuttle Information ---");
        mySpaceShuttle.displayInfo();
        mySpaceShuttle.startEngine();
        System.out.println();
    
        
        System.out.println("=====Truck Information=====");
        myTruck.displayInfo();
        myTruck.startEngine();
        System.out.println();
        
        System.out.println("=====SUV info=====");
        mySUV.displayInfo();
        mySUV.startEngine();
        System.out.println();
        
        System.out.println("=====Tricycle info=====");
        myTricycle.displayInfo();
        myTricycle.startEngine();
        System.out.println();
        
        System.out.println("=====Motorcycle info=====");
        myMotorcycle.displayInfo();
        myMotorcycle.startEngine();
        System.out.println();
        
        System.out.println("===== Kariton Information =====");
        myKariton.displayInfo();
        myKariton.startEngine();
        System.out.println();

        System.out.println("===== Boat Information ======");
        myBoat.displayInfo();
        myBoat.startEngine();
        System.out.println();

        System.out.println("===== Ship Information =====");
        myShip.displayInfo();
        myShip.startEngine();
        System.out.println();
    }
}