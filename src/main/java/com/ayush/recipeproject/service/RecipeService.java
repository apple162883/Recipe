package com.ayush.recipeproject.service;

import com.ayush.recipeproject.command.RecipeCommand;
import com.ayush.recipeproject.entity.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> recipes();
    Recipe findById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
    RecipeCommand findCommandById(Long id);
    void deleteById(Long id);
}
