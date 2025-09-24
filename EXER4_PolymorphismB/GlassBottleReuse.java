public class GlassBottleReuse extends ReuseWaste {
    public GlassBottleReuse(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void dispose() {
        System.out.println("Clean and reuse glass bottle: " + name);
    }
}