package com.ayush.recipeproject.converter;

import com.ayush.recipeproject.command.CategoryCommand;
import com.ayush.recipeproject.entity.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {
    @Nullable
    @Synchronized
    @Override
    public Category convert(CategoryCommand source) {
        Category category = new Category();
        if(source == null){
            return null;
        }
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}
