package pro.sky.java.course2.recipesapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.recipesapp.model.Ingredient;
import pro.sky.java.course2.recipesapp.model.Recipe;
import pro.sky.java.course2.recipesapp.services.RecipeService;
import pro.sky.java.course2.recipesapp.services.impl.RecipeServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/recipe")
@Tag(name = "Рецепты", description = "CRUD-операции для работы с рецептами")
public class RecipeController {
    private final RecipeServiceImpl recipeServiceImpl;

    public RecipeController(RecipeServiceImpl recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Поиск рецепта по id",
            description = "Искать нужно по идентификационному номеру")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт был найден",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Recipe.class)
                            )
                    }
            )})
    @Parameters(value = {
            @Parameter(name = "id",
                    example = "целое положительное число")
    })
    public ResponseEntity<Recipe> getById(@PathVariable int id) {
        Recipe recipe = recipeServiceImpl.getById(id);
        if (recipe==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipeServiceImpl.getById(id));
    }

    @PostMapping
    @Operation(summary = "Добавление рецепта", description = "Добавление возможно при заполнении всех полей")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт добален",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Recipe.class)
                            )
                    }
            )
    })
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return this.recipeServiceImpl.addRecipe(recipe);
    }

    @GetMapping
    @Operation(summary = "Получение всех рецептов",description = "Поиск производится без параметров")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепты получены",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Recipe.class)
                            )
                    }
            )
    })
    public Collection<Recipe> getAll() {
        return this.recipeServiceImpl.getAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменение рецептов по id",description = "Изменить можно все поля, кроме идентификационного номера")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт изменен",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Recipe.class)
                            )
                    }
            )
    })
    @Parameters(value = {
            @Parameter(name = "id",
                    example = "целое положительное число")
    })
    public Recipe updateRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
        return recipeServiceImpl.updateRecipe(id, recipe);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление рецептов по id",description = "Удалить рецепт можно только по идентификационному номеру")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт удален",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Recipe.class)
                            )
                    }
            )
    })
    @Parameters(value = {
            @Parameter(name = "id",
                    example = "целое положительное число")
    })
    public Recipe removeRecipe(int id) {
        return recipeServiceImpl.removeRecipe(id);
    }

}
