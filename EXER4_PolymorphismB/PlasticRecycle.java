public class PlasticRecycle extends RecycleWaste {
    public PlasticRecycle(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void dispose() {
        System.out.println("Recycle plastic properly: " + name);
    }
}