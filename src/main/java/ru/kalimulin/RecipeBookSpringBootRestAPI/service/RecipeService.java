package ru.kalimulin.RecipeBookSpringBootRestAPI.service;

import ru.kalimulin.RecipeBookSpringBootRestAPI.DTO.RecipeCreateDTO;
import ru.kalimulin.RecipeBookSpringBootRestAPI.DTO.RecipeResponseDTO;
import ru.kalimulin.RecipeBookSpringBootRestAPI.DTO.RecipeUpdateDTO;

import java.util.List;

public interface RecipeService {
    RecipeResponseDTO createRecipe(RecipeCreateDTO recipeCreateDTO);
    RecipeResponseDTO getRecipeById(Long id);
    List<RecipeResponseDTO> getAllRecipes();
    RecipeResponseDTO updateRecipe(RecipeUpdateDTO updateDTO);
    void deleteRecipeById(Long id);
}
