public class ReduceWaste extends Waste {
    public ReduceWaste(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void dispose() {
        System.out.println("Try to reduce usage of: " + name);
    }
}