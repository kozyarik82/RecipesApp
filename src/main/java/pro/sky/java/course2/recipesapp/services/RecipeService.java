package pro.sky.java.course2.recipesapp.services;

import pro.sky.java.course2.recipesapp.model.Recipe;

import java.util.Collection;

public interface RecipeService {
    public Recipe addRecipe(Recipe recipe);

    public Recipe getById(int id);

    Collection<Recipe> getAll();

    Recipe updateRecipe(int id, Recipe recipe);

    Recipe removeRecipe(int id);
}
