package mythosforge.fable_minds.models;

import org.hibernate.annotations.Comment;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Characters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Comment("The name of the character")
    @Size(min = 1, max = 50, message = "Character name must be between 1 and 50 characters long")
    private String name;

    @Column(length = 512)
    @Comment("A short description of the character backstory")
    private String background;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    @Comment("The campaign this character belongs to")
    private Campaigns campaign;
}

