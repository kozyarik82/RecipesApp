package pro.sky.java.course2.recipesapp.services;

import pro.sky.java.course2.recipesapp.model.Ingredient;
import pro.sky.java.course2.recipesapp.services.impl.NotFailedException;

import java.util.Collection;

public interface IngredientService {
    public Ingredient addIngredient(Ingredient ingredient) throws NotFailedException;

    public Ingredient getById(int id);

    Collection<Ingredient> getAll();

    Ingredient updateIngredient(int id, Ingredient ingredient) throws NotFailedException;

    Ingredient removeIngredient(int id);
}
