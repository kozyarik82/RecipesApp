package pro.sky.java.course2.recipesapp.services;

import java.io.File;

public interface FilesServiceIngredient {


    boolean saveToFileIngredient(String json);



    String readFromFileIngredient();

    boolean cleanDataFileIngredient();

    File getDataFileIngredient();
}
