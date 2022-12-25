package pro.sky.java.course2.recipesapp.model;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private final int id;

    private String title;
    private  int timeOfPreparing;
    private List<Ingredient> ingredients = new ArrayList<>();
    private List<String> steps = new ArrayList<>();

    public Recipe(int id, String title, int timeOfPreparing, List<Ingredient> ingredients, List<String> steps) {
        this.id = id;
        this.title = title;
        this.timeOfPreparing = timeOfPreparing;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getTimeOfPreparing() {
        return timeOfPreparing;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTimeOfPreparing(int timeOfPreparing) {
        this.timeOfPreparing = timeOfPreparing;
    }
}
