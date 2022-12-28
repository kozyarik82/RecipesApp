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
import pro.sky.java.course2.recipesapp.services.IngredientService;
import pro.sky.java.course2.recipesapp.services.impl.IngredientServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/ingredient")
@Tag(name="Ингредиенты",description = "CRUD-операции для работы с ингредиентами")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "Поиск ингредиента по id",
            description = "Искать нужно по идентификационному номеру")
    @ApiResponses(value = {
            @ApiResponse(
            responseCode = "200",
            description = "Ингредиенты были найдены",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Ingredient.class)
                    )
            }
    )})
    @Parameters(value = {
            @Parameter(name = "id",
            example = "целое положительное число")
    })
    public ResponseEntity<Ingredient> getById(@PathVariable int id) {
        Ingredient ingredient = ingredientService.getById(id);
        if (ingredient==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredientService.getById(id));
    }
    @PostMapping
    @Operation(summary = "Добавление ингредиента", description = "Добавление возможно при заполнении всех полей")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиент добален",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Ingredient.class)
                            )
                    }
            )
    })
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.addIngredient(ingredient);
    }

    @GetMapping
    @Operation(summary = "Получение всех ингредиентов",description = "Поиск производится без параметров")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиенты получены",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Ingredient.class)
                            )
                    }
            )
    })
    public Collection<Ingredient> getAll() {
        return this.ingredientService.getAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменение ингредиентов по id",description = "Изменить можно только amount и unitOfMeasure")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиент изменен",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Ingredient.class)
                            )
                    }
            )
    })
    @Parameters(value = {
            @Parameter(name = "id",
                    example = "целое положительное число")
    })
    public Ingredient updateIngredient(@PathVariable int id, @RequestBody Ingredient ingredient) {
        return this.ingredientService.updateIngredient(id,ingredient);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление ингредиентов по id",description = "Удалить ингредиент можно только по идентификационному номеру")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиент удален",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Ingredient.class)
                            )
                    }
            )
    })
    @Parameters(value = {
            @Parameter(name = "id",
                    example = "целое положительное число")
    })
    public Ingredient removeIngredient(@PathVariable int id) {
        return this.ingredientService.removeIngredient(id);
    }


}
