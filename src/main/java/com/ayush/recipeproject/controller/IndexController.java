package com.ayush.recipeproject.controller;

import com.ayush.recipeproject.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {
   private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    private String getIndexPage(Model model){
        log.debug("Controller logger");
        model.addAttribute("recipes",recipeService.recipes());
        return "index";
    }

}
