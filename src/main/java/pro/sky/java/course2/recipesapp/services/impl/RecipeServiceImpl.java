package pro.sky.java.course2.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.recipesapp.model.Recipe;
import pro.sky.java.course2.recipesapp.services.RecipeService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final Map<Integer, Recipe> recipes = new HashMap<>();

    @Override
    public Recipe addRecipe(Recipe recipe) {
        recipes.put(recipe.getId(), recipe);
        return recipe;
    }

    @Override
    public Recipe getById(int id) {
        return recipes.get(id);
    }

    @Override
    public Collection<Recipe> getAll() {
        return recipes.values();
    }

    @Override
    public Recipe updateRecipe(int id, Recipe recipe) {
        Recipe serviceRecipe = recipes.get(id);
        serviceRecipe.setTitle(recipe.getTitle());
        serviceRecipe.setTimeOfPreparing(recipe.getTimeOfPreparing());
        serviceRecipe.setIngredients(recipe.getIngredients());
        serviceRecipe.setSteps(recipe.getSteps());
        return serviceRecipe;
    }

    @Override
    public Recipe removeRecipe(int id) {
        return recipes.remove(id);
    }
}
