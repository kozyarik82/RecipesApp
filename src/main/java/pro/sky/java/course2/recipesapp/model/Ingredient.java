package pro.sky.java.course2.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Ingredient {
    private int id;
    private String title;
    private int amount;
    private String unitOfMeasure;
}
