package pro.sky.java.course2.recipesapp.controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.java.course2.recipesapp.services.FilesServiceRecipe;

import java.io.*;

@RestController
@RequestMapping("/files")
public class FilesRecipeController {
    private final FilesServiceRecipe filesServiceRecipe;

    public FilesRecipeController(FilesServiceRecipe filesServiceRecipe) {
        this.filesServiceRecipe = filesServiceRecipe;
    }
    @GetMapping("/export")
    public ResponseEntity<InputStreamResource> downloadFileRecipe() throws FileNotFoundException {
        File file = filesServiceRecipe.getDataFileRecipe();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(file.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename = \"RecipesLog.json\"")
                    .body(resource);
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    @PostMapping(value = "/import",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadDataFileRecipe(@RequestParam MultipartFile file) {
        filesServiceRecipe.cleanDataFileRecipe();
        File dataFileRecipe = filesServiceRecipe.getDataFileRecipe();
        try (FileOutputStream fos = new FileOutputStream(dataFileRecipe)) {
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }
}
