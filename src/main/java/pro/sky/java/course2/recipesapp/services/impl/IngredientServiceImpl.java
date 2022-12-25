package pro.sky.java.course2.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.recipesapp.model.Ingredient;
import pro.sky.java.course2.recipesapp.services.IngredientService;

import java.util.Collection;
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
    @Override
    public Collection<Ingredient> getAll() {
        return ingredients.values();
    }

    @Override
    public Ingredient updateIngredient(int id, Ingredient ingredient) {
        Ingredient serviceIngredient = ingredients.get(id);
        if (serviceIngredient == null) {
            throw new RuntimeException("такого ингредиента не существует!");
        }
        serviceIngredient.setAmount(ingredient.getAmount());
        serviceIngredient.setUnitOfMeasure(ingredient.getUnitOfMeasure());
        return serviceIngredient;
    }

    @Override
    public Ingredient removeIngredient(int id) {
        return ingredients.remove(id);
    }

}
