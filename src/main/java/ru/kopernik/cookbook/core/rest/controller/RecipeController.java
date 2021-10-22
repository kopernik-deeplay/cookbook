package ru.kopernik.cookbook.core.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kopernik.cookbook.core.entity.Recipe;
import ru.kopernik.cookbook.core.rest.exception.RecipeNotFoundException;
import ru.kopernik.cookbook.core.repository.RecipeRepository;
import ru.kopernik.cookbook.core.rest.dto.RecipeDTO;

/**
 * REST-контроллер для рецептов
 */
@RestController
@AllArgsConstructor
public class RecipeController {
    private RecipeRepository recipeRepository;

    @GetMapping("/recipes")
    public Iterable<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @PostMapping("/recipes")
    public Recipe createRecipe(@RequestBody RecipeDTO recipeDTO) {
        Recipe recipe = Recipe.builder()
                .title(recipeDTO.getTitle())
                .description(recipeDTO.getDescription())
                .build();
        return recipeRepository.save(recipe);
    }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));
    }

    @DeleteMapping("/recipes/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeRepository.deleteById(id);
    }
}
