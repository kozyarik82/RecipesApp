package pro.sky.java.course2.recipesapp.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.recipesapp.model.Recipe;
import pro.sky.java.course2.recipesapp.services.FilesServiceRecipe;
import pro.sky.java.course2.recipesapp.services.RecipeService;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final FilesServiceRecipe filesServiceRecipe;
    private  HashMap<Integer, Recipe> recipes = new HashMap<>();

    public RecipeServiceImpl(FilesServiceRecipe filesServiceRecipe) {
        this.filesServiceRecipe = filesServiceRecipe;
    }


    @PostConstruct
    private void initRecipe() {
        readFromFileRecipe();
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        recipes.put(recipe.getId(), recipe);
        saveToFileRecipe();
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
        saveToFileRecipe();
        return serviceRecipe;
    }

    @Override
    public Recipe removeRecipe(int id) {
        return recipes.remove(id);
    }

    private void saveToFileRecipe() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipes);
            filesServiceRecipe.saveToFileRecipe(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFileRecipe() {
        try {
            String json = filesServiceRecipe.readFromFileRecipe();
            recipes = new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
