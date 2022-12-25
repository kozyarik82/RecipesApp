package pro.sky.java.course2.recipesapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.recipesapp.model.Ingredient;
import pro.sky.java.course2.recipesapp.services.IngredientService;
import pro.sky.java.course2.recipesapp.services.impl.IngredientServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientServiceImpl ingredientServiceImpl;


    public IngredientController(IngredientServiceImpl ingredientServiceImpl) {
        this.ingredientServiceImpl = ingredientServiceImpl;
    }
    @GetMapping("/{id}")
    public Ingredient getById(@PathVariable int id) {
        return ingredientServiceImpl.getById(id);
    }

    @PostMapping
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientServiceImpl.addIngredient(ingredient);
    }

    @GetMapping
    public Collection<Ingredient> getAll() {
        return this.ingredientServiceImpl.getAll();
    }

    @PutMapping("/{id}")
    public Ingredient updateIngredient(@PathVariable int id, @RequestBody Ingredient ingredient) {
        return this.ingredientServiceImpl.updateIngredient(id,ingredient);
    }

    @DeleteMapping("/{id}")
    public Ingredient removeIngredient(@PathVariable int id) {
        return this.ingredientServiceImpl.removeIngredient(id);
    }


}
