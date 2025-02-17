package ru.kalimulin.RecipeBookSpringBootRestAPI.mapper;

import org.springframework.stereotype.Component;
import ru.kalimulin.RecipeBookSpringBootRestAPI.DTO.RecipeCreateDTO;
import ru.kalimulin.RecipeBookSpringBootRestAPI.DTO.RecipeResponseDTO;
import ru.kalimulin.RecipeBookSpringBootRestAPI.models.Recipe;

@Component
public class RecipeMapperImpl implements RecipeMapper {

    @Override
    public RecipeResponseDTO toRecipeResponseDTO(Recipe recipe) {
        if (recipe == null) {
            return null;
        }
        return RecipeResponseDTO.builder()
                .id(recipe.getId())
                .name(recipe.getName())
                .description(recipe.getDescription())
                .ingredients(recipe.getIngredients())
                .build();
    }

    @Override
    public Recipe toRecipe(RecipeCreateDTO recipeCreateDTO) {
        if(recipeCreateDTO == null) {
            return null;
        }

        return Recipe.builder()
                .name(recipeCreateDTO.getName())
                .description(recipeCreateDTO.getDescription())
                .ingredients(recipeCreateDTO.getIngredients())
                .build();
    }
}
