public class ProjectTester {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   WASTE MANAGEMENT: REDUCE | REUSE | RECYCLE");
        System.out.println("==================================================\n");

       
        System.out.println(" REDUCE WASTE");
        
        PackagingWaste packaging = new PackagingWaste("Plastic Packaging", 0.2);
        packaging.describe();
        packaging.dispose();
        System.out.println();

        FoodWasteReduce foodReduce = new FoodWasteReduce("Leftover Vegetables", 0.5);
        foodReduce.describe();
        foodReduce.dispose();
        System.out.println("--------------------------------------------------\n");

        System.out.println(" REUSE WASTE");

        GlassBottleReuse glass = new GlassBottleReuse("Wine Bottle", 1.2);
        glass.describe();
        glass.dispose();
        System.out.println();

        ClothReuse cloth = new ClothReuse("Old T-Shirt", 0.3);
        cloth.describe();
        cloth.dispose();
        System.out.println("--------------------------------------------------\n");

        System.out.println(" RECYCLE WASTE");

        PlasticRecycle plastic = new PlasticRecycle("Plastic Bottle", 0.4);
        plastic.describe();
        plastic.dispose();
        System.out.println();

        PaperRecycle paper = new PaperRecycle("Newspaper", 0.7);
        paper.describe();
        paper.dispose();
        System.out.println("--------------------------------------------------\n");

        
        System.out.println("All waste items have been classified and processed successfully.");
        System.out.println("Please continue to reduce, reuse, and recycle responsibly.");
    }
}

