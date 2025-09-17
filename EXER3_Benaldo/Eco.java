// EcoSystemMain.java
import java.util.Scanner;

public class Eco{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🌍 Welcome to the Eco-Friendly System 🌱");
        System.out.println("Choose an option:");
        System.out.println("1. Reduce");
        System.out.println("2. Reuse");
        System.out.println("3. Recycle");
        System.out.println("4. Care for Environment");
        System.out.print("Enter your choice (1-4): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter your specific action: ");
        String action = scanner.nextLine();

        EcoAction eco = null;

        // Assign category and benefit based on choice
        switch (choice) {
            case 1:
                eco = new EcoAction(action, "Reduce", "Helps minimize waste and save resources.");
                break;
            case 2:
                eco = new EcoAction(action, "Reuse", "Extends product life and reduces pollution.");
                break;
            case 3:
                eco = new EcoAction(action, "Recycle", "Converts waste into new products and reduces landfill use.");
                break;
            case 4:
                eco = new EcoAction(action, "Care", "Protects nature, improves health, and preserves ecosystems.");
                break;
            default:
                System.out.println("Invalid choice. Please restart.");
                System.exit(0);
        }

        // Display result
        System.out.println("\n✅ Your Eco Action Details:");
        System.out.println("Action: " + eco.getAction());
        System.out.println("Category: " + eco.getCategory());
        System.out.println("Benefit: " + eco.getBenefit());

        scanner.close();
    }
}
