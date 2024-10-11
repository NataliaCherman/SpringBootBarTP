package be.ipamc.bartp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RecipeId", nullable = false)
    private Integer recipeId;

    @Size(max = 4000)
    @Nationalized
    @Column(name = "Description", length = 4000)
    private String description;

    @Size(max = 500)
    @Nationalized
    @Column(name = "Image", length = 500)
    private String image;

    @Size(max = 200)
    @Nationalized
    @Column(name = "Name", length = 200)
    private String name;

}