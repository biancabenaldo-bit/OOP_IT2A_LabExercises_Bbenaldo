public class Waste {
    protected String name;
    protected double weight;

    public Waste(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    // Base methods - overridden in child classes
    public void describe() {
        System.out.println("Waste Name: " + name);
        System.out.println("Weight: " + weight + " kg");
    }

    public void dispose() {
        System.out.println("Dispose in general waste bin.");
    }
}