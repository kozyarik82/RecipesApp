package pro.sky.java.course2.recipesapp.services;

import pro.sky.java.course2.recipesapp.model.Ingredient;

public interface IngredientService {
    public Ingredient addIngredient(Ingredient ingredient);

    public Ingredient getById(int id);
}
