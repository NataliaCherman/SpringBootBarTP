package be.ipamc.bartp.services;

import be.ipamc.bartp.dto.RecipeDto;
import be.ipamc.bartp.mappers.RecipeMapper;
import be.ipamc.bartp.model.Recipe;
import be.ipamc.bartp.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private RecipeMapper recipeMapper;


    public Optional<RecipeDto> getRecipeById(int id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe.map(recipeMapper::toDto);
    }

    public RecipeDto createRecipe(RecipeDto recipeDto) {
        Recipe recipe = recipeMapper.toEntity(recipeDto);
        recipe = recipeRepository.save(recipe);
        return recipeMapper.toDto(recipe);
    }

    public Optional<RecipeDto> updateRecipe(int id, RecipeDto recipeDto) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            Recipe recipeToUpdate = recipeMapper.toEntity(recipeDto);
            recipeToUpdate.setRecipeId(id);
            recipeToUpdate = recipeRepository.save(recipeToUpdate);
            return Optional.of(recipeMapper.toDto(recipeToUpdate));
        }
        return Optional.empty();
    }

    public Boolean deleteRecipe(int id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            recipeRepository.delete(recipe.get());
            return true;
        }
        return false;
    }
}
