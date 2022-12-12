package pro.sky.java.course2.recipesapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping
    public String hello() {
        return "Приложение запущено";
    }

    @GetMapping("/info")
    public String info(@RequestParam String info) {
        return "Info: имя разработчика: Kozyar Oxana, название проекта: Recipes, дата создания 12.12.2022, опимание: приложение предназначено для создания рецептов" + info;
    }
}
