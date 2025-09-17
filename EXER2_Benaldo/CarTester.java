public class CarTester {
    public static void main(String[] args) {
        
        Car[] cars = new Car[10]; // 10 CARS

        cars[0] = new Car("Black", "BMW123", "CH001", "BMW", "Germany", 6000000);
        cars[1] = new Car("White", "CAD456", "CH002", "Cadillac", "USA", 7500000);
        cars[2] = new Car("Silver", "CHR789", "CH003", "Chrysler", "USA", 3500000);
        cars[3] = new Car("Blue", "ALP111", "CH004", "Alpina", "Germany", 9000000);
        cars[4] = new Car("Gray", "AUD222", "CH005", "Audi", "Germany", 5000000);
        cars[5] = new Car("Green", "BEN333", "CH006", "Bentley", "UK", 12000000);
        cars[6] = new Car("Red", "BRA444", "CH007", "Brabus", "Germany", 15000000);
        cars[7] = new Car("Orange", "CHE555", "CH008", "Chery", "China", 1200000);
        cars[8] = new Car("Yellow", "TES666", "CH009", "Tesla", "USA", 8000000);
        cars[9] = new Car("Purple", "LAM777", "CH010", "Lamborghini", "Italy", 20000000);

        //  all car details
        for (Car car : cars) {
            car.displayInfo();
        }
    }
}
