package pro.sky.java.course2.recipesapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Приветствие",description = "Начало работы приложения")
public class FirstController {
    @GetMapping
    @Operation(summary = "Первый запуск приложения",description = "Приветствие")
    public String hello() {
        return "Приложение запущено";
    }

    @GetMapping("/info")
    @Operation(summary = "Информация о приложении",description = "Имя разработчика, дата создания и описание")
    public String info() {
        return "Info: имя разработчика: Kozyar Oxana, название проекта: Recipes, дата создания 12.12.2022, описание: приложение предназначено для создания рецептов";
    }
}
