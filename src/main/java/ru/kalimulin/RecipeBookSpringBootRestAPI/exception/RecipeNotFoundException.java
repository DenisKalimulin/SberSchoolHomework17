package ru.kalimulin.RecipeBookSpringBootRestAPI.exception;

public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException(String message) {
        super(message);
    }
}
