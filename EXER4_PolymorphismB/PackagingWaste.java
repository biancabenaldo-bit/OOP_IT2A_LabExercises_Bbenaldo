public class PackagingWaste extends ReduceWaste {
    public PackagingWaste(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void dispose() {
        System.out.println("Reduce packaging waste by choosing eco bag: " + name);
    }
}