package Miniprojet.MiniProjetBackend.LigneEmploi.Rattrapage;

import Miniprojet.MiniProjetBackend.Emploi.Rattrapage.EmploiRattrapage;
import Miniprojet.MiniProjetBackend.Ennumeration.TypeSeance;
import Miniprojet.MiniProjetBackend.LigneEmploi.LigneEmploi;
import Miniprojet.MiniProjetBackend.Matiere.Matiere;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import Miniprojet.MiniProjetBackend.Salle.Salle;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LigneEmploiRattrapage extends LigneEmploi {
    @Enumerated
    private TypeSeance type;
    @ManyToOne
    @JoinColumn(name = "id-emploi_R", nullable = false)
    private EmploiRattrapage emploiR;

    @ManyToOne
    @JoinColumn(name = "salle")
    private Salle salle_R;

    @ManyToOne
    @JoinColumn(name = "Enseignant", nullable = false)
    private Enseignant enseignant_R;

    @ManyToOne
    @JoinColumn(name = "matiere", nullable = false)
    private Matiere matiere_R;
}
