package pro.sky.java.course2.recipesapp.model;

import java.util.List;

public class Recipe {
    private final int id;

    private final String title;
    private final int timeOfPreparing;
    private final List<Ingredient> ingredients;
    private final List<String> steps;

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
}
