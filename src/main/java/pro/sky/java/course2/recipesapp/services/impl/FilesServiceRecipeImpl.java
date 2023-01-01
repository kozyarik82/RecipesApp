package pro.sky.java.course2.recipesapp.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.recipesapp.services.FilesServiceRecipe;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
@Service
public class FilesServiceRecipeImpl implements FilesServiceRecipe {
    @Value("${path.to.recipe.file}")
    private String dataFilePathRecipe;
    @Value("${name.of.recipe.file}")
    private String dataFileNameRecipe;
    @Override
    public boolean saveToFileRecipe(String json) {
        try {
            cleanDataFileRecipe();
            Files.writeString(Path.of(dataFilePathRecipe, dataFileNameRecipe), json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    @Override
    public String readFromFileRecipe() {
        try {
            return Files.readString(Path.of(dataFilePathRecipe, dataFileNameRecipe));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean cleanDataFileRecipe() {
        try {
            Path path = Path.of(dataFilePathRecipe, dataFileNameRecipe);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public File getDataFileRecipe() {
        return new File(dataFilePathRecipe + "/" + dataFileNameRecipe);
    }
}
