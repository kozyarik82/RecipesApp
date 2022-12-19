package pro.sky.java.course2.recipesapp.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.recipesapp.model.Ingredient;
import pro.sky.java.course2.recipesapp.services.IngredientService;
import pro.sky.java.course2.recipesapp.services.impl.IngredientServiceImpl;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientServiceImpl ingredientService;

    public IngredientController(IngredientServiceImpl ingredientService) {
        this.ingredientService = ingredientService;
    }
    @GetMapping
    public Ingredient getById(int id) {
        return ingredientService.getById(id);
    }

    @PostMapping
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.addIngredient(ingredient);
    }
}
