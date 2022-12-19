package pro.sky.java.course2.recipesapp.services;

import pro.sky.java.course2.recipesapp.model.Recipe;

public interface RecipeService {
    public Recipe addRecipe(Recipe recipe);

    public Recipe getById(int id);
}
