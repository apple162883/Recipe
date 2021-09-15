package com.ayush.recipeproject.converter;

import com.ayush.recipeproject.command.RecipeCommand;
import com.ayush.recipeproject.entity.Category;
import com.ayush.recipeproject.entity.Ingredient;
import com.ayush.recipeproject.entity.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {
    private final CategoryToCategoryCommand categoryConverter;
    private final IngredientToIngredientCommand ingredientConverter;
    private final NotesToNotesCommand notesConverter;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryConverter, IngredientToIngredientCommand ingredientConverter, NotesToNotesCommand notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Nullable
    @Synchronized
    @Override
    public RecipeCommand convert(Recipe source) {
        if(source == null){
            return null;
        }
        final RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(source.getId());
        recipeCommand.setDescription(source.getDescription());
        recipeCommand.setPrepTime(source.getPrepTime());
        recipeCommand.setCookTime(source.getCookTime());
        recipeCommand.setServings(source.getServings());
        recipeCommand.setSource(source.getSource());
        recipeCommand.setUrl(source.getUrl());
        recipeCommand.setDirection(source.getDirection());
        recipeCommand.setDifficulty(source.getDifficulty());
        recipeCommand.setNotes(notesConverter.convert(source.getNotes()));
        if(source.getCategories()!= null && source.getCategories().size() > 0){
            for (Category category: source.getCategories()) {
                recipeCommand.getCategories().add(categoryConverter.convert(category));
            }
        }
        if(source.getIngredients()!=null && source.getIngredients().size() > 0){
            for (Ingredient ingredients: source.getIngredients()) {
                recipeCommand.getIngredients().add(ingredientConverter.convert(ingredients));
            }
        }
        return recipeCommand;
    }
}
