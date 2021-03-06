package com.mateuyabar.android.cleanapp.presentation.presenters;

import com.mateuyabar.android.cleanapp.domain.models.Recipe;
import com.mateuyabar.android.cleanapp.domain.usecases.RecipeUseCases;
import com.mateuyabar.android.cleanbase.presentation.presenters.BasePresenter;


public class ShowRecipeDetailPresenter extends BasePresenter{
    ViewRenderer view;
    int recipeId;
    RecipeUseCases recipeUseCases = new RecipeUseCases();


    public void initialize(ViewRenderer view, int recipeId){
        this.view = view;
        this.recipeId = recipeId;
        loadRecipe();
    }

    private void loadRecipe() {
        Recipe recipe = recipeUseCases.getRecipe(recipeId);
        view.render(recipe);
    }

    public static interface ViewRenderer {
        public void render(Recipe recipie);
    }
}
