package com.ayush.recipeproject.converter;

import com.ayush.recipeproject.command.IngredientCommand;
import com.ayush.recipeproject.entity.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {
    private final UOMToUOMCommand uConvert;

    public IngredientToIngredientCommand(UOMToUOMCommand uConvert) {
        this.uConvert = uConvert;
    }

    @Nullable
    @Synchronized
    @Override
    public IngredientCommand convert(Ingredient source) {
        if(source == null){
            return null;
        }
        final IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(source.getId());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setAmount(source.getAmount());
        ingredientCommand.setUnitOfMeasureCommand(uConvert.convert(source.getUnitOfMeasure()));
        return ingredientCommand;
    }
}