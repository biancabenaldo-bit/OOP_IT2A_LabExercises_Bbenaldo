public class FoodWasteReduce extends ReduceWaste {
    public FoodWasteReduce(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void dispose() {
        System.out.println("Reduce food waste by meal planning and leftovers for: " + name);
    }
}