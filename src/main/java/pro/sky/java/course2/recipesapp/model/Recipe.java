package pro.sky.java.course2.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Recipe {
    private final int id;

    private String title;
    private  int timeOfPreparing;
    private List<Ingredient> ingredients = new ArrayList<>();
    private List<String> steps = new ArrayList<>();
}
