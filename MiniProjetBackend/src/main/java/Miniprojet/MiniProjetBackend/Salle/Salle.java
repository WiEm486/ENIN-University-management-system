package Miniprojet.MiniProjetBackend.Salle;

import Miniprojet.MiniProjetBackend.Block.Block;
import Miniprojet.MiniProjetBackend.Ennumeration.TypeSalle;
import Miniprojet.MiniProjetBackend.LigneEmploi.Etude.LigneEmploiEtude;
import Miniprojet.MiniProjetBackend.LigneEmploi.Examen.LigneEmploiExamen;
import Miniprojet.MiniProjetBackend.LigneEmploi.LigneEmploi;
import Miniprojet.MiniProjetBackend.LigneEmploi.Rattrapage.LigneEmploiRattrapage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id_salle;
    private String noms;
    @Enumerated(EnumType.STRING)
    private TypeSalle type;
    @ManyToOne
    @JoinColumn(name = "id_block")
    private Block block;

    @OneToMany(mappedBy = "salle_et")
    private List<LigneEmploiEtude> lignes_emploi_et;

    @OneToMany(mappedBy = "salle_ex")
    private List<LigneEmploiExamen> lignes_emploi_ex;

    @OneToMany(mappedBy = "salle_R")
    private List<LigneEmploiRattrapage> lignes_emploi_R;

}
