package pro.sky.java.course2.recipesapp.services;

import pro.sky.java.course2.recipesapp.services.impl.NotFailedException;

import java.io.File;

public interface FilesServiceIngredient {


    boolean saveToFileIngredient(String json);



    String readFromFileIngredient() throws NotFailedException;

    boolean cleanDataFileIngredient();

    File getDataFileIngredient();
}
