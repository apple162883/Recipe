package com.ayush.recipeproject.command;

import com.ayush.recipeproject.entity.Category;
import com.ayush.recipeproject.entity.Difficulty;
import com.ayush.recipeproject.entity.Ingredient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String direction;
    private Difficulty difficulty;
    private NotesCommand notes;
    private Byte[] image;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Set<CategoryCommand> categories = new HashSet<>();

    public NotesCommand getNotes() {
        return notes;
    }

    public void setNotes(NotesCommand notes) {
        this.notes = notes;
    }
}
