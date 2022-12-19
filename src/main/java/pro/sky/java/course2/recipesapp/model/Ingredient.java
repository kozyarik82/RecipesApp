package pro.sky.java.course2.recipesapp.model;

public class Ingredient {
    private final int id;
    private final String title;
    private final int amount;
    private final String unitOfMeasure;

    public Ingredient(int id,String title, int amount, String unitOfMeasure) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getAmount() {
        return amount;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }
}
