package ru.kalimulin.RecipeBookSpringBootRestAPI.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kalimulin.RecipeBookSpringBootRestAPI.models.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
