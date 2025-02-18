package ru.kalimulin.RecipeBookSpringBootRestAPI.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.kalimulin.RecipeBookSpringBootRestAPI.DTO.RecipeResponseDTO;
import ru.kalimulin.RecipeBookSpringBootRestAPI.models.Recipe;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeMapperImplTest {
    private RecipeMapperImpl recipeMapper;

    @BeforeEach
    void setUp() {
        recipeMapper = new RecipeMapperImpl();
    }

    static Stream<Arguments> provideRecipesForMapping() {
        return Stream.of(
                Arguments.of(new Recipe(1L, "Pasta", "Delicious pasta", "Noodles, Sauce"),
                        new RecipeResponseDTO(1L, "Pasta", "Delicious pasta", "Noodles, Sauce")),
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @MethodSource("provideRecipesForMapping")
    void testToRecipeResponseDTO(Recipe input, RecipeResponseDTO expected) {
        assertEquals(expected, recipeMapper.toRecipeResponseDTO(input));
    }
}
