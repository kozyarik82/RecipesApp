package pro.sky.java.course2.recipesapp.controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.java.course2.recipesapp.services.FilesServiceIngredient;

import java.io.*;

@RestController
@RequestMapping("/files/ingredient")
public class FilesIngredientController {
    private final FilesServiceIngredient filesServiceIngredient;

    public FilesIngredientController(FilesServiceIngredient filesServiceIngredient) {
        this.filesServiceIngredient = filesServiceIngredient;
    }
    @GetMapping("/export")
    public ResponseEntity<InputStreamResource> downloadIngredientFile()throws FileNotFoundException {
        File file = filesServiceIngredient.getDataFileIngredient();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(file.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename =\"Ingredients.Log.json\"")
                    .body(resource);
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    @PostMapping(value = "/import",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadDataFileIngredient(@RequestParam MultipartFile file) {
        filesServiceIngredient.cleanDataFileIngredient();
        File dataFileIngredient = filesServiceIngredient.getDataFileIngredient();
        try (FileOutputStream fos = new FileOutputStream(dataFileIngredient)) {
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }
}
