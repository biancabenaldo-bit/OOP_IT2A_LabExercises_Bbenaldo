public class EcoAction {
    // Encapsulated fields
    private String action;
    private String category;
    private String benefit;

    // Constructor
    public EcoAction(String action, String category, String benefit) {
        this.action = action;
        this.category = category;
        this.benefit = benefit;
    }

    // Getters
    public String getAction() {
        return action;
    }

    public String getCategory() {
        return category;
    }

    public String getBenefit() {
        return benefit;
    }
}
