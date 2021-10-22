package ru.kopernik.cookbook.core.rest.exception;

public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException(Long id) {
        super("Рецепт с идентификатором " + id + " не существует");
    }
}
