package com.ayush.recipeproject.converter;

import com.ayush.recipeproject.command.CategoryCommand;
import com.ayush.recipeproject.command.IngredientCommand;
import com.ayush.recipeproject.command.RecipeCommand;
import com.ayush.recipeproject.entity.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
    private final CategoryCommandToCategory categoryConverter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NotesCommandToNotes notesConverter;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryConverter, IngredientCommandToIngredient ingredientConverter, NotesCommandToNotes notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Nullable
    @Synchronized
    @Override
    public Recipe convert(RecipeCommand source) {
        if(source == null){
            return null;
        }
        final Recipe recipe = new Recipe();
        recipe.setDifficulty(source.getDifficulty());
        recipe.setDirection(source.getDirection());
        recipe.setNotes(notesConverter.convert(source.getNotes()));
        recipe.setDescription(source.getDescription());
        recipe.setSource(source.getSource());
        recipe.setUrl(source.getUrl());
        recipe.setCookTime(source.getCookTime());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setServings(source.getServings());
        recipe.setId(source.getId());
        if(source.getCategories()!= null && source.getCategories().size() > 0){
            for (CategoryCommand categoryCommand: source.getCategories()) {
                recipe.getCategories().add(categoryConverter.convert(categoryCommand));
            }
        }
        if(source.getCategories()!= null && source.getCategories().size() > 0){
            for (IngredientCommand ingredientCommand:source.getIngredients()) {
                recipe.getIngredients().add(ingredientConverter.convert(ingredientCommand));
            }
        }

        return recipe;
    }
}
