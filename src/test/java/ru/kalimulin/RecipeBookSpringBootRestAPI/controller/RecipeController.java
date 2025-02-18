package ru.kalimulin.RecipeBookSpringBootRestAPI.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.kalimulin.RecipeBookSpringBootRestAPI.DTO.RecipeCreateDTO;
import ru.kalimulin.RecipeBookSpringBootRestAPI.DTO.RecipeResponseDTO;
import ru.kalimulin.RecipeBookSpringBootRestAPI.service.RecipeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class RecipeControllerTest {
    @Mock
    private RecipeService recipeService;
    @InjectMocks
    private RecipeController recipeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateRecipe() {
        RecipeCreateDTO createDTO = new RecipeCreateDTO("Cake", "Sweet", "Flour, Sugar");
        RecipeResponseDTO responseDTO = new RecipeResponseDTO(1L, "Cake", "Sweet", "Flour, Sugar");
        when(recipeService.createRecipe(createDTO)).thenReturn(responseDTO);

        ResponseEntity<RecipeResponseDTO> response = recipeController.createRecipe(createDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(responseDTO, response.getBody());
    }
}
