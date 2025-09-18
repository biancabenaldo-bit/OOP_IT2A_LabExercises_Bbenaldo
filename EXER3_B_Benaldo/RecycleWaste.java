public class RecycleWaste extends Waste {
    public RecycleWaste(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void dispose() {
        System.out.println("Recycle item: " + name);
    }
}