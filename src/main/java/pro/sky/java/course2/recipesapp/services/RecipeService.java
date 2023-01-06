package pro.sky.java.course2.recipesapp.services;

import pro.sky.java.course2.recipesapp.model.Recipe;
import pro.sky.java.course2.recipesapp.services.impl.NotFailedException;

import java.util.Collection;

public interface RecipeService {
    public Recipe addRecipe(Recipe recipe) throws NotFailedException;

    public Recipe getById(int id);

    Collection<Recipe> getAll();

    Recipe updateRecipe(int id, Recipe recipe) throws NotFailedException;

    Recipe removeRecipe(int id);
}
