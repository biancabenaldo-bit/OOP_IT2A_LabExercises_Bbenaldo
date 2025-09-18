public class ReuseWaste extends Waste {
    public ReuseWaste(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void dispose() {
        System.out.println("Reuse item: " + name);
    }
}