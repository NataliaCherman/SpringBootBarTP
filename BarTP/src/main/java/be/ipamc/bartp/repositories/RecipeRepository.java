package be.ipamc.bartp.repositories;

import be.ipamc.bartp.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
  }