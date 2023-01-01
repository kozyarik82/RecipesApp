package pro.sky.java.course2.recipesapp.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.recipesapp.services.FilesServiceIngredient;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
@Service
public class FilesServiceIngredientImpl implements FilesServiceIngredient {
    @Value("${path.to.ingredient.file}")
    private String dataFilePathIngredient;
    @Value("${name.of.ingredient.file}")
    private String dataFileNameIngredient;

    @Override
    public boolean saveToFileIngredient(String json) {
        try {
            cleanDataFileIngredient();
            Files.writeString(Path.of(dataFilePathIngredient, dataFileNameIngredient), json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String readFromFileIngredient() {
        try {
            return Files.readString(Path.of(dataFilePathIngredient, dataFileNameIngredient));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean cleanDataFileIngredient() {
        try {
            Path path = Path.of(dataFilePathIngredient, dataFileNameIngredient);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public File getDataFileIngredient() {
        return new File(dataFilePathIngredient + "/" + dataFileNameIngredient);
    }
}
