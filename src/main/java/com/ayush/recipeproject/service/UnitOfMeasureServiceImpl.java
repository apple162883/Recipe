package com.ayush.recipeproject.service;

import com.ayush.recipeproject.command.UnitOfMeasureCommand;
import com.ayush.recipeproject.converter.UOMToUOMCommand;
import com.ayush.recipeproject.repository.UnitOfMeasureRepository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UOMToUOMCommand uomToUOMCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UOMToUOMCommand uomToUOMCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.uomToUOMCommand = uomToUOMCommand;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
        return StreamSupport.stream(unitOfMeasureRepository.findAll()
                        .spliterator(), false)
                .map(uomToUOMCommand::convert)
                .collect(Collectors.toSet());
    }
}
