package com.ayush.recipeproject.service;

import com.ayush.recipeproject.command.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}
