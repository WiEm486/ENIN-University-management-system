package Miniprojet.MiniProjetBackend.Cours;

import Miniprojet.MiniProjetBackend.Matiere.Matiere;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Date;
@RequiredArgsConstructor
@Data
@Entity
public class Cours {
    @Id
    @GeneratedValue(generator = "cours-generator")
    @GenericGenerator(name = "cours-generator",
            parameters = @Parameter(name = "prefix", value = "cours"),
            strategy = "Miniprojet.MiniProjetBackend.MyGenerator")
    private String id_cours;
    @Column
    private  String contenu;
    @Column
    private Date date_depot;
    @ManyToOne
    @JoinColumn(name = "id_matiere", nullable = false)
    private Matiere matiere;
    @ManyToOne
    @JoinColumn(name = "num_enseignant", nullable = false)
    private Enseignant enseignant;

}
