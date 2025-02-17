package ru.kalimulin.RecipeBookSpringBootRestAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kalimulin.RecipeBookSpringBootRestAPI.DTO.RecipeCreateDTO;
import ru.kalimulin.RecipeBookSpringBootRestAPI.DTO.RecipeResponseDTO;
import ru.kalimulin.RecipeBookSpringBootRestAPI.DTO.RecipeUpdateDTO;
import ru.kalimulin.RecipeBookSpringBootRestAPI.mapper.RecipeMapper;
import ru.kalimulin.RecipeBookSpringBootRestAPI.models.Recipe;
import ru.kalimulin.RecipeBookSpringBootRestAPI.repository.RecipeRepository;
import ru.kalimulin.RecipeBookSpringBootRestAPI.exception.RecipeNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    @Override
    @Transactional
    public RecipeResponseDTO createRecipe(RecipeCreateDTO recipeCreateDTO) {
        Recipe recipe = recipeMapper.toRecipe(recipeCreateDTO);
        recipeRepository.save(recipe);
        return recipeMapper.toRecipeResponseDTO(recipe);
    }

    @Override
    public RecipeResponseDTO getRecipeById(Long id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Рецепт с id " + id + " не найден"));

        return recipeMapper.toRecipeResponseDTO(recipe);
    }

    @Override
    public List<RecipeResponseDTO> getAllRecipes() {
        List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();
        return recipes.stream()
                .map(recipeMapper::toRecipeResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public RecipeResponseDTO updateRecipe(RecipeUpdateDTO updateDTO) {
        Recipe recipe = recipeRepository.findById(updateDTO.getId())
                .orElseThrow(() -> new RecipeNotFoundException("Рецепт с id " + updateDTO.getId() + " не найден"));
        if (updateDTO.getName() != null) {
            recipe.setName(updateDTO.getName());
        }
        if (updateDTO.getDescription() != null) {
            recipe.setDescription(updateDTO.getDescription());
        }
        if (updateDTO.getIngredients() != null) {
            recipe.setIngredients(updateDTO.getIngredients());
        }

        recipeRepository.save(recipe);

        return recipeMapper.toRecipeResponseDTO(recipe);
    }

    @Override
    public void deleteRecipeById(Long id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Рецепт с id " + id + " не найден"));
        recipeRepository.delete(recipe);
    }
}