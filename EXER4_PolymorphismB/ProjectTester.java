public class ProjectTester {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   WASTE MANAGEMENT: REDUCE | REUSE | RECYCLE");
        System.out.println("==================================================\n");

        // Array of Waste references → Runtime Polymorphism
        Waste[] wastes = new Waste[] {
            new PackagingWaste("Plastic Packaging", 0.2),
            new FoodWasteReduce("Leftover Vegetables", 0.5),
            new GlassBottleReuse("Wine Bottle", 1.2),
            new ClothReuse("Old T-Shirt", 0.3),
            new PlasticRecycle("Plastic Bottle", 0.4),
            new PaperRecycle("Newspaper", 0.7)
        };

        // Loop through and call methods dynamically
        for (Waste w : wastes) {
            w.describe();   // Parent method
            w.dispose();    // Overridden method (child-specific)
            System.out.println("--------------------------------------------------\n");
        }

        // Compile-time Polymorphism (Method Overloading)
        System.out.println(" POLYMORPHISM TEST: Method Overloading");
        describeWaste("Battery");
        describeWaste("Food Scraps", 0.6);

        System.out.println("==================================================");
        System.out.println("All waste items have been classified and processed successfully.");
        System.out.println("Please continue to reduce, reuse, and recycle responsibly.");
    }

    // Overloaded methods (Compile-time Polymorphism)
    public static void describeWaste(String name) {
        System.out.println("Waste Item: " + name);
    }

    public static void describeWaste(String name, double weight) {
        System.out.println("Waste Item: " + name + " | Weight: " + weight + " kg");
    }
}