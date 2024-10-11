package be.ipamc.bartp.controllers;

import be.ipamc.bartp.dto.RecipeDto;
import be.ipamc.bartp.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/recipe")

public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    // CRUD operations :

    // GET
    @GetMapping("/{id}")
    public ResponseEntity<RecipeDto> findRecipeById(@PathVariable int id) {
        Optional<RecipeDto> recipe = recipeService.getRecipeById(id);
        return recipe.map(ResponseEntity::ok) // Si recette trouvée -> 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Sinon -> 404 Not Found
    }

    // POST -> Create
    @PostMapping()
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody RecipeDto recipeDto) {
        RecipeDto recipe = recipeService.createRecipe(recipeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(recipe); // -> 201 Created
    }

    // PUT -> Update
    @PutMapping("/{id}")
    public ResponseEntity<RecipeDto> updateRecipe(@PathVariable int id, @RequestBody RecipeDto recipeDto) {
        Optional<RecipeDto> recipe = recipeService.updateRecipe(id, recipeDto);
        return recipe.map(ResponseEntity::ok) // Si recette mise à jour -> 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Sinon -> 404 Not Found
    }


    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id) {
        boolean isDeleted = recipeService.deleteRecipe(id);
        return isDeleted // -> 204 No Content si supprimée, sinon 404 Not Found
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
