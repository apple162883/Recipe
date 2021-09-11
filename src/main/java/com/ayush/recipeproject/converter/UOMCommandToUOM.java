package com.ayush.recipeproject.converter;

import com.ayush.recipeproject.command.UnitOfMeasureCommand;
import com.ayush.recipeproject.entity.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UOMCommandToUOM implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {
    @Nullable
    @Synchronized
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        if(source == null){
            return null;
        }
        final UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(source.getId());
        unitOfMeasure.setUom(source.getUom());
        return unitOfMeasure;
    }
}
