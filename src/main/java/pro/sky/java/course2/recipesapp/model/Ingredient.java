package pro.sky.java.course2.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Ingredient {
    private final int id;
    private  final String title;
    private   int amount;
    private   String unitOfMeasure;
}
