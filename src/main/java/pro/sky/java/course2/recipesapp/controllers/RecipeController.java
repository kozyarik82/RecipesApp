package pro.sky.java.course2.recipesapp.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.recipesapp.model.Recipe;
import pro.sky.java.course2.recipesapp.services.RecipeService;
import pro.sky.java.course2.recipesapp.services.impl.RecipeServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeServiceImpl recipeServiceImpl;

    public RecipeController(RecipeServiceImpl recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }
    @GetMapping("/{id}")
    public Recipe getById(@PathVariable int id) {
        return recipeServiceImpl.getById(id);
    }
    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return this.recipeServiceImpl.addRecipe(recipe);
    }

    @GetMapping
    public Collection<Recipe> getAll() {
        return this.recipeServiceImpl.getAll();
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
        return recipeServiceImpl.updateRecipe(id, recipe);
    }

    @DeleteMapping("/{id}")
    public Recipe removeRecipe(int id) {
        return recipeServiceImpl.removeRecipe(id);
    }

}
