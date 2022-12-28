package pro.sky.java.course2.recipesapp.services;

public interface FilesServiceRecipe {

    boolean saveToFileRecipe(String json);

    String readFromFileRecipe();
}
