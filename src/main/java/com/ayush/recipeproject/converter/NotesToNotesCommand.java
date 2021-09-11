package com.ayush.recipeproject.converter;

import com.ayush.recipeproject.command.NotesCommand;
import com.ayush.recipeproject.entity.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {
    @Nullable
    @Synchronized
    @Override
    public NotesCommand convert(Notes source) {
        if(source == null){
            return null;
        }
        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(source.getId());
        notesCommand.setRecipeNotes(source.getRecipeNotes());
        return notesCommand;
    }
}