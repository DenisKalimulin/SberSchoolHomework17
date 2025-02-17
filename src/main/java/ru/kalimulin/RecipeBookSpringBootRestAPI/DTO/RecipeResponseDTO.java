package ru.kalimulin.RecipeBookSpringBootRestAPI.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String ingredients;
}
