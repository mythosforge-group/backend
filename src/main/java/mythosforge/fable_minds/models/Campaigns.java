package mythosforge.fable_minds.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Comment;

@Entity
@Data
public class Campaigns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Comment("The title of the campaign")
    @Size(min = 1, max = 100, message = "Campaign title must be between 1 and 100 characters long")
    private String title;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Users owner;

    @Column(length = 512)
    @Comment("The narrative description of the campaign")
    private String description;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    @Comment("List of characters in the campaign, ")
    private List<Characters> characters = new ArrayList<>();

    // @ManyToMany(mappedBy = "user")
    // @Comment("List of players in the campaign")
    // private List<User> players = new ArrayList<>();
}