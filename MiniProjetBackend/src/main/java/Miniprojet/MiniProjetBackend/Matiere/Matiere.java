package Miniprojet.MiniProjetBackend.Matiere;

import Miniprojet.MiniProjetBackend.Cours.Cours;
import Miniprojet.MiniProjetBackend.LigneEmploi.Etude.LigneEmploiEtude;
import Miniprojet.MiniProjetBackend.LigneEmploi.Examen.LigneEmploiExamen;
import Miniprojet.MiniProjetBackend.LigneEmploi.Rattrapage.LigneEmploiRattrapage;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.List;
@RequiredArgsConstructor
@Data
@Entity
public class Matiere {
    @Id
    @GeneratedValue(generator = "Matiere-generator")
    @GenericGenerator(name = "Matiere-generator",
            parameters = @Parameter(name = "prefix", value = "Mat"),
            strategy = "Miniprojet.MiniProjetBackend.MyGenerator")
    private String id_matiere;
    private String nom;
//    @ManyToMany(mappedBy = "listeMatieres")
//    private List<Enseignant> listeEnseignants;
    @OneToMany(mappedBy = "matiere")
    public List<Cours> Cours_Deposes;
    @OneToMany(mappedBy = "matiere_et")
    private List<LigneEmploiEtude> lignes_emploi_et;

    @OneToMany(mappedBy = "matiere_R")
    private List<LigneEmploiRattrapage> lignes_emploi_R;

    @OneToMany(mappedBy = "matiere_ex")
    private List<LigneEmploiExamen> lignes_emploi_ex;

}
