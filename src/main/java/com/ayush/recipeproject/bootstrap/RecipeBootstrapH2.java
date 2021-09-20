package com.ayush.recipeproject.bootstrap;

import com.ayush.recipeproject.entity.*;
import com.ayush.recipeproject.repository.CategoryRepository;
import com.ayush.recipeproject.repository.RecipeRepository;
import com.ayush.recipeproject.repository.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@Profile("default")
public class RecipeBootstrapH2 implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrapH2(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
        log.debug("Bootstrap logger");
    }

    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>();

        Recipe chiRecipe = new Recipe();
        chiRecipe.setDescription("Spicy Grilled Chicken Tacos");
        chiRecipe.setPrepTime(20);
        chiRecipe.setCookTime(15);
        chiRecipe.setServings(6);
        chiRecipe.setSource("Simply Recipes");
        chiRecipe.setUrl("https://www.simplyrecipes.com" +
                 "/recipes/spicy_grilled_chicken_tacos/");
        chiRecipe.setDirection("Prepare a gas or charcoal grill for medium-high, direct heat\n" +
                "Make the marinade and coat the chicken:\n" +
                "In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings." +
                "Grill the chicken:\n" +
                "Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "Warm the tortillas:\n" +
                "Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "Assemble the tacos:\n" +
                "Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
       chiRecipe.setDifficulty(Difficulty.MODERATE);

       Notes chiNotes = new Notes();
       chiNotes.setRecipeNotes("Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder," +
               " you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)");
       chiNotes.setRecipe(chiRecipe);
       chiRecipe.setNotes(chiNotes);

        Optional<UnitOfMeasure> tablespoonOptional = unitOfMeasureRepository.findByUom("Tablespoon");
        Optional<UnitOfMeasure> teaspoonOptional = unitOfMeasureRepository.findByUom("Teaspoon");
        Optional<UnitOfMeasure> cupOptional = unitOfMeasureRepository.findByUom("Cup");
        Optional<UnitOfMeasure> pinchOptional = unitOfMeasureRepository.findByUom("Pinch");
        Optional<UnitOfMeasure> ounceOptional = unitOfMeasureRepository.findByUom("Ounce");
        Optional<UnitOfMeasure> eachOptional = unitOfMeasureRepository.findByUom("Each");
        Optional<UnitOfMeasure> dashOptional = unitOfMeasureRepository.findByUom("Dash");
        Optional<UnitOfMeasure> pintOptional = unitOfMeasureRepository.findByUom("Pint");
        UnitOfMeasure tableUom = tablespoonOptional.get();
        UnitOfMeasure teaUom = teaspoonOptional.get();
        UnitOfMeasure cupUom = cupOptional.get();
        UnitOfMeasure pinchUom = pinchOptional.get();
        UnitOfMeasure ounceUom = ounceOptional.get();
        UnitOfMeasure eachUom = eachOptional.get();
        UnitOfMeasure dashUom = dashOptional.get();
        UnitOfMeasure pintUom = pintOptional.get();

        Optional<Category> americanOptional = categoryRepository.findByDescription("American");
        Optional<Category> mexicanOptional = categoryRepository.findByDescription("Mexican");
        Category americanCategory = americanOptional.get();
        Category mexicanCategory = mexicanOptional.get();

        chiRecipe.getIngredients().add(new Ingredient("Chilli powder",new BigDecimal(2),chiRecipe,tableUom));
        chiRecipe.getIngredients().add(new Ingredient("Dried Oregano",new BigDecimal(1),chiRecipe,teaUom));
        chiRecipe.getIngredients().add(new Ingredient("Dried Cumin",new BigDecimal(1),chiRecipe,teaUom));
        chiRecipe.getIngredients().add(new Ingredient("Sugar",new BigDecimal(1),chiRecipe,teaUom));
        chiRecipe.getIngredients().add(new Ingredient("Salt",new BigDecimal(1),chiRecipe,teaUom));
        chiRecipe.getIngredients().add(new Ingredient("Garlic",new BigDecimal(1),chiRecipe,eachUom));

        chiRecipe.getCategories().add(americanCategory);
        chiRecipe.getCategories().add(mexicanCategory);
        recipes.add(chiRecipe);

        Recipe guaRecipe = new Recipe();
        guaRecipe.setDescription("Perfect Guacamole");
        guaRecipe.setPrepTime(10);
        guaRecipe.setCookTime(0);
        guaRecipe.setServings(4);
        guaRecipe.setSource("Simply Recipes");
        guaRecipe.setUrl("https://www.simplyrecipes.com" +
                "/recipes/spicy_grilled_chicken_tacos/");
        guaRecipe.setDirection("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                                "\n 2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                                "\n 3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown." +
                                "\n Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness." +
                                "\nRemember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste." +
                                "\n 4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve." +
                                "\n 5 Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving." +
                                "\n Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");
        guaRecipe.setDifficulty(Difficulty.EASY);

        Notes guaNotes = new Notes();
        guaNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados." +
                                "\n Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries." +
                                "\n The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole." +
                                "\n To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great." +
                                "\n Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
        guaNotes.setRecipe(guaRecipe);
        guaRecipe.setNotes(guaNotes);

        guaRecipe.getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2),guaRecipe,eachUom));
        guaRecipe.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(.5), guaRecipe,teaUom));
        guaRecipe.getIngredients().add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), guaRecipe,tableUom));
        guaRecipe.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2),guaRecipe,tableUom));
        guaRecipe.getIngredients().add(new Ingredient("serrano chillies, stems and seeds removed, minced", new BigDecimal(2),guaRecipe,eachUom));
        guaRecipe.getIngredients().add(new Ingredient("Cilantro", new BigDecimal(2),guaRecipe,tableUom));
        guaRecipe.getIngredients().add(new Ingredient("freshly grated black pepper", new BigDecimal(2), guaRecipe,pintUom));
        guaRecipe.getIngredients().add(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(.5),guaRecipe, eachUom));

        guaRecipe.getCategories().add(americanCategory);
        guaRecipe.getCategories().add(mexicanCategory);
        recipes.add(guaRecipe);
       //end of program
       return recipes;
    }
}
