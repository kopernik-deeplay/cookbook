package ru.kopernik.cookbook.core.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class RecipeDTO {
    private String title;
    private String description;
}
