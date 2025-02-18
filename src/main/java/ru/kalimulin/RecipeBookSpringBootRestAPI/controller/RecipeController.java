package ru.kalimulin.RecipeBookSpringBootRestAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kalimulin.RecipeBookSpringBootRestAPI.DTO.RecipeCreateDTO;
import ru.kalimulin.RecipeBookSpringBootRestAPI.DTO.RecipeResponseDTO;
import ru.kalimulin.RecipeBookSpringBootRestAPI.DTO.RecipeUpdateDTO;
import ru.kalimulin.RecipeBookSpringBootRestAPI.service.RecipeService;

import java.util.List;

@RestController
@RequestMapping("/recipe-book")
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/create")
    public ResponseEntity<RecipeResponseDTO> createRecipe(@RequestBody RecipeCreateDTO recipeCreateDTO) {
        RecipeResponseDTO recipeResponseDTO = recipeService.createRecipe(recipeCreateDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(recipeResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponseDTO> findById(@PathVariable Long id) {
        RecipeResponseDTO recipeResponseDTO = recipeService.getRecipeById(id);

        return ResponseEntity.ok(recipeResponseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RecipeResponseDTO>> findAll() {
        List<RecipeResponseDTO> list = recipeService.getAllRecipes();

        return ResponseEntity.ok(list);
    }

    @PutMapping("/update")
    public ResponseEntity<RecipeResponseDTO> updateRecipe(RecipeUpdateDTO recipeUpdateDTO) {
        RecipeResponseDTO recipeResponseDTO = recipeService.updateRecipe(recipeUpdateDTO);

        return ResponseEntity.ok(recipeResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipeById(id);

        return ResponseEntity.ok("Рецепт удален");
    }
}