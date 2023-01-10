package pro.sky.java.course2.recipesapp.services;

import pro.sky.java.course2.recipesapp.services.impl.NotFailedException;

import java.io.File;

public interface FilesServiceRecipe {

    boolean saveToFileRecipe(String json);

    String readFromFileRecipe() throws NotFailedException;

    boolean cleanDataFileRecipe();

    File getDataFileRecipe();
}
