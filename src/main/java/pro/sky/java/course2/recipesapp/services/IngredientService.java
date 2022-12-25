package pro.sky.java.course2.recipesapp.services;

import pro.sky.java.course2.recipesapp.model.Ingredient;

import java.util.Collection;

public interface IngredientService {
    public Ingredient addIngredient(Ingredient ingredient);

    public Ingredient getById(int id);

    Collection<Ingredient> getAll();

    Ingredient updateIngredient(int id, Ingredient ingredient);

    Ingredient removeIngredient(int id);
}
