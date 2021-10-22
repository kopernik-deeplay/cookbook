package ru.kopernik.cookbook.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kopernik.cookbook.core.entity.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
