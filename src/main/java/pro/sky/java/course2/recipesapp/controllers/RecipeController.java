package pro.sky.java.course2.recipesapp.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.recipesapp.model.Recipe;
import pro.sky.java.course2.recipesapp.services.RecipeService;
import pro.sky.java.course2.recipesapp.services.impl.RecipeServiceImpl;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeServiceImpl recipeService;

    public RecipeController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }
    @GetMapping
    public Recipe getById(int id) {
        return recipeService.getById(id);
    }
    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return this.recipeService.addRecipe(recipe);
    }

}
