public class PaperRecycle extends RecycleWaste {
    public PaperRecycle(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void dispose() {
        System.out.println("Recycle paper properly: " + name);
    }
}

