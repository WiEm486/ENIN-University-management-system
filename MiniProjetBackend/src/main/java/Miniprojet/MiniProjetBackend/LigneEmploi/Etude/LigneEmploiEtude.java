package Miniprojet.MiniProjetBackend.LigneEmploi.Etude;

import Miniprojet.MiniProjetBackend.Emploi.Etude.EmploiEtude;
import Miniprojet.MiniProjetBackend.Ennumeration.Regime;
import Miniprojet.MiniProjetBackend.Ennumeration.TypeSeance;
import Miniprojet.MiniProjetBackend.LigneEmploi.LigneEmploi;
import Miniprojet.MiniProjetBackend.Matiere.Matiere;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import Miniprojet.MiniProjetBackend.Salle.Salle;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Data
public class LigneEmploiEtude extends LigneEmploi {
    @Column
    @Enumerated(EnumType.STRING)
    private Regime regime;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeSeance type;
    @ManyToOne
    @JoinColumn(name = "id_emploiEt", nullable = false)
    private EmploiEtude emploiEt;

    @ManyToOne
    @JoinColumn(name = "salle")
    private Salle salle_et;

    @ManyToOne
    @JoinColumn(name = "Enseignant", nullable = false)
    private Enseignant enseignant_et;

    @ManyToOne
    @JoinColumn(name = "matiere", nullable = false)
    private Matiere matiere_et;
}
