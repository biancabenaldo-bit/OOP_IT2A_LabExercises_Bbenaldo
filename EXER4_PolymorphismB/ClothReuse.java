public class ClothReuse extends ReuseWaste {
    public ClothReuse(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void dispose() {
        System.out.println("Reuse old cloths or fabric for: " + name);
    }
}