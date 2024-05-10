package Miniprojet.MiniProjetBackend.RapportDeStage;

import Miniprojet.MiniProjetBackend.Profile.Etudiant.Etudiant;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Date;

@RequiredArgsConstructor
@Data
@Entity
public class RapportDeStage {
    @Id
    @GeneratedValue(generator = "rapport-generator")
    @GenericGenerator(name = "rapport-generator",
            parameters = @Parameter(name = "prefix", value = "Rap"),
            strategy = "Miniprojet.MiniProjetBackend.MyGenerator")
    public String id_Rapport;
    @Column
    public String contenu;
    @Column
    public Date date_soumission;
    @Column
    public String status;

    @ManyToOne
    @JoinColumn(name = "proprirtaire_id", nullable = false)
    private Etudiant proprietaire;

}
