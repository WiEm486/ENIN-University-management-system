package Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeRattrapage;

import Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeAdministrative;
import Miniprojet.MiniProjetBackend.Ennumeration.Jour;
import Miniprojet.MiniProjetBackend.LigneEmploi.LigneEmploi;
import Miniprojet.MiniProjetBackend.Matiere.Matiere;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import Miniprojet.MiniProjetBackend.groupe.Groupe;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalTime;

@Data
@RequiredArgsConstructor
@Entity

public class DemandeRattrapage extends DemandeAdministrative {

    @Id
    @GeneratedValue(generator = "Drat-generator")
    @GenericGenerator(name = "Drat-generator",
            parameters = @Parameter(name = "prefix", value = "DemR"),
            strategy = "Miniprojet.MiniProjetBackend.MyGenerator")
    private String id_demandeR;
    @Column
    @Enumerated(EnumType.STRING)
    private Jour jour;
    @Column
    private LocalTime debut;
    @Column
    private LocalTime fin;
    @ManyToOne
    @JoinColumn(name = "enseignant", nullable = false)
    private Enseignant proprietaireR;
    @ManyToOne
    private Groupe groupe;
    @ManyToOne
    private Matiere matiere;
}
