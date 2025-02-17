package ru.kalimulin.RecipeBookSpringBootRestAPI.mapper;

import ru.kalimulin.RecipeBookSpringBootRestAPI.DTO.RecipeCreateDTO;
import ru.kalimulin.RecipeBookSpringBootRestAPI.DTO.RecipeResponseDTO;
import ru.kalimulin.RecipeBookSpringBootRestAPI.models.Recipe;

public interface RecipeMapper {
    RecipeResponseDTO toRecipeResponseDTO(Recipe recipe);

    Recipe toRecipe(RecipeCreateDTO recipeCreateDTO);
}
