package com.ayush.recipeproject.controller;

import com.ayush.recipeproject.command.RecipeCommand;
import com.ayush.recipeproject.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class RecipeController {
   public final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/{id}/show")
    public String showRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe",recipeService.findById(Long.valueOf(id)));
        return "recipe/show";
    }
    @RequestMapping("/recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe",new RecipeCommand());
        return "recipe/receptor";
    }
    @PostMapping("recipe")
    public String saveOrUpdate(RecipeCommand recipeCommand){
        RecipeCommand saveCommand = recipeService.saveRecipeCommand(recipeCommand);
        return "redirect:/recipe/" + saveCommand.getId() + "/show";
    }
    @RequestMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id,Model model){
        model.addAttribute("recipe",recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/receptor";
    }


}
