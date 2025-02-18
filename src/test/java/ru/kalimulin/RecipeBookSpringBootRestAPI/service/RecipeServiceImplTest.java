package ru.kalimulin.RecipeBookSpringBootRestAPI.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.kalimulin.RecipeBookSpringBootRestAPI.DTO.RecipeCreateDTO;
import ru.kalimulin.RecipeBookSpringBootRestAPI.DTO.RecipeResponseDTO;
import ru.kalimulin.RecipeBookSpringBootRestAPI.mapper.RecipeMapper;
import ru.kalimulin.RecipeBookSpringBootRestAPI.models.Recipe;
import ru.kalimulin.RecipeBookSpringBootRestAPI.repository.RecipeRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RecipeServiceImplTest {
    @Mock
    private RecipeRepository recipeRepository;
    @Mock
    private RecipeMapper recipeMapper;
    @InjectMocks
    private RecipeServiceImpl recipeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateRecipe() {
        RecipeCreateDTO createDTO = new RecipeCreateDTO("Soup", "Tasty", "Water, Vegetables");
        Recipe recipe = new Recipe(null, "Soup", "Tasty", "Water, Vegetables");
        RecipeResponseDTO responseDTO = new RecipeResponseDTO(1L, "Soup", "Tasty", "Water, Vegetables");

        when(recipeMapper.toRecipe(createDTO)).thenReturn(recipe);
        when(recipeRepository.save(recipe)).thenReturn(recipe);
        when(recipeMapper.toRecipeResponseDTO(recipe)).thenReturn(responseDTO);

        RecipeResponseDTO result = recipeService.createRecipe(createDTO);
        assertEquals(responseDTO, result);
    }
}