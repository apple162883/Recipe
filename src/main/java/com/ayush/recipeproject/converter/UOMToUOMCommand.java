package com.ayush.recipeproject.converter;

import com.ayush.recipeproject.command.UnitOfMeasureCommand;
import com.ayush.recipeproject.entity.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UOMToUOMCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {
    @Nullable
    @Synchronized
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if(source == null){
            return null;
        }
        final UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(source.getId());
        unitOfMeasureCommand.setUom(source.getUom());
        return unitOfMeasureCommand;
    }
}
