package com.ayush.recipeproject.service;

import com.ayush.recipeproject.command.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long id);
    IngredientCommand saveIngredientCommand(IngredientCommand command);
}
