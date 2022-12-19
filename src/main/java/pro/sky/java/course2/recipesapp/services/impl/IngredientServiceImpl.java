package pro.sky.java.course2.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.recipesapp.model.Ingredient;
import pro.sky.java.course2.recipesapp.services.IngredientService;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final Map<Integer, Ingredient> ingredients = new HashMap<>();
    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        if (ingredients.isEmpty()) {
            throw new RuntimeException("Данные отсутствуют!");
        } else {
            ingredients.put(ingredient.getId(), ingredient);
        }
        return ingredient;
    }

    @Override
    public Ingredient getById(int id) {
        if (ingredients.containsKey(id)) {
            return ingredients.get(id);
        } else {
            throw new RuntimeException("Такого ингдеиента не существует!");
        }
    }
}
