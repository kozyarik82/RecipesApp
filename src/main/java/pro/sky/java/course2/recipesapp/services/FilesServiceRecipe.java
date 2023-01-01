package pro.sky.java.course2.recipesapp.services;

import java.io.File;

public interface FilesServiceRecipe {

    boolean saveToFileRecipe(String json);

    String readFromFileRecipe();

    boolean cleanDataFileRecipe();

    File getDataFileRecipe();
}
