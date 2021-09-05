package com.ayush.recipeproject.repository;

import com.ayush.recipeproject.entity.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
