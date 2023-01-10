package pro.sky.java.course2.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private int id;
    private String title;
    private int timeOfPreparing;
    private List<Ingredient> ingredients = new ArrayList<>();
    private List<String> steps = new ArrayList<>();
}
