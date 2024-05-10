package Miniprojet.MiniProjetBackend.LigneEmploi.Examen;

import Miniprojet.MiniProjetBackend.Emploi.Examen.EmploiExamen;
import Miniprojet.MiniProjetBackend.LigneEmploi.LigneEmploi;
import Miniprojet.MiniProjetBackend.Matiere.Matiere;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import Miniprojet.MiniProjetBackend.Salle.Salle;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Data
public class LigneEmploiExamen extends LigneEmploi {
    @ManyToOne
    @JoinColumn(name = "id_emploiEx", nullable = false)
    private EmploiExamen emploiEx;

    @ManyToOne
    @JoinColumn(name = "salle")
    private Salle salle_ex;

    @ManyToOne
    @JoinColumn(name = "Enseignant", nullable = false)
    private Enseignant enseignant_ex;

    @ManyToOne
    @JoinColumn(name = "matiere", nullable = false)
    private Matiere matiere_ex;
}
