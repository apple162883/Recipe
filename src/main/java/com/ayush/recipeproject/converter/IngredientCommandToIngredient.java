package com.ayush.recipeproject.converter;

import com.ayush.recipeproject.command.IngredientCommand;
import com.ayush.recipeproject.entity.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {
    private final UOMCommandToUOM uConvert;

    public IngredientCommandToIngredient(UOMCommandToUOM uConvert) {
        this.uConvert = uConvert;
    }

    @Nullable
    @Synchronized
    @Override
    public Ingredient convert(IngredientCommand source) {
        if(source == null){
            return null;
        }
        Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setDescription(source.getDescription());
        ingredient.setAmount(source.getAmount());
        ingredient.setUnitOfMeasure(uConvert.convert(source.getUnitOfMeasureCommand()));
        return ingredient;
    }
}
