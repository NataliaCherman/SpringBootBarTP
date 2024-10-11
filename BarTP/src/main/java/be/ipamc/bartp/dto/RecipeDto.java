package be.ipamc.bartp.dto;

import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link be.ipamc.bartp.model.Recipe}
 */
@Value
public class RecipeDto implements Serializable {
    Integer recipeId;
    @Size(max = 4000)
    String description;
    @Size(max = 500)
    String image;
    @Size(max = 200)
    String name;
}