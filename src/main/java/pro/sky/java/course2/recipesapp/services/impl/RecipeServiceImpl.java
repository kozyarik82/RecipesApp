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
        if (recipes.isEmpty()) {
            throw new RuntimeException("Данные отсутствуют!");
        } else {
            recipes.put(recipe.getId(), recipe);
        }
        return recipe;
    }

    @Override
    public Recipe getById(int id) {
        if (recipes.containsKey(id)) {
            return recipes.get(id);
        } else {
            throw new RuntimeException("Такого рецепта не существует!");
        }
    }
    @Override
    public Collection<Recipe> getAll() {
        return recipes.values();
    }

    @Override
    public Recipe updateRecipe(int id, Recipe recipe) {
        Recipe serviceRecipe = recipes.get(id);
        if (serviceRecipe == null) {
            throw new RuntimeException("Такого рецепта не существует!");
        }
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
