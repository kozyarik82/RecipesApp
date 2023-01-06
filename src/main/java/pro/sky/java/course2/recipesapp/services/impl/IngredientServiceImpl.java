package pro.sky.java.course2.recipesapp.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.recipesapp.model.Ingredient;
import pro.sky.java.course2.recipesapp.services.FilesServiceIngredient;
import pro.sky.java.course2.recipesapp.services.IngredientService;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final FilesServiceIngredient filesServiceIngredient;

    private HashMap<Integer, Ingredient> ingredients = new HashMap<>();

    public IngredientServiceImpl(FilesServiceIngredient filesServiceIngredient) {
        this.filesServiceIngredient = filesServiceIngredient;
    }


    @PostConstruct
    private void initIngredient() throws NotFailedException {
        readFromFileIngredient();
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) throws NotFailedException {
        ingredients.put(ingredient.getId(), ingredient);
        saveToFileIngredient();
        return ingredient;
    }

    @Override
    public Ingredient getById(int id) {
        return ingredients.get(id);
    }

    @Override
    public Collection<Ingredient> getAll() {
        return ingredients.values();
    }

    @Override
    public Ingredient updateIngredient(int id, Ingredient ingredient) throws NotFailedException {
        Ingredient serviceIngredient = ingredients.get(id);
        serviceIngredient.setAmount(ingredient.getAmount());
        serviceIngredient.setUnitOfMeasure(ingredient.getUnitOfMeasure());
        saveToFileIngredient();
        return serviceIngredient;
    }

    @Override
    public Ingredient removeIngredient(int id) {
        return ingredients.remove(id);
    }

    private void saveToFileIngredient() throws NotFailedException{
        try {
            String json = new ObjectMapper().writeValueAsString(ingredients);
            filesServiceIngredient.saveToFileIngredient(json);
        } catch (JsonProcessingException e) {
            throw new NotFailedException("Файл не удалось сохранить!");
        }
    }

    private void readFromFileIngredient() throws NotFailedException{
        try {
            String json = filesServiceIngredient.readFromFileIngredient();
            ingredients = new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            throw new NotFailedException("Файл не удалось прочитать!");
        }
    }

}
