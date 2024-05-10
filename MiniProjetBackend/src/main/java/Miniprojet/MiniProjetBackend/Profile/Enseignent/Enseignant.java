package Miniprojet.MiniProjetBackend.Profile.Enseignent;

import Miniprojet.MiniProjetBackend.Cours.Cours;
import Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeConges.DemandeConges;
import Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeRattrapage.DemandeRattrapage;
import Miniprojet.MiniProjetBackend.Departement.Departement;
import Miniprojet.MiniProjetBackend.Grade.Grade;
import Miniprojet.MiniProjetBackend.LigneEmploi.Etude.LigneEmploiEtude;
import Miniprojet.MiniProjetBackend.LigneEmploi.Examen.LigneEmploiExamen;
import Miniprojet.MiniProjetBackend.LigneEmploi.Rattrapage.LigneEmploiRattrapage;
import Miniprojet.MiniProjetBackend.Matiere.Matiere;
import Miniprojet.MiniProjetBackend.Profile.Profile;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Enseignant extends Profile {
    private String num_enseignant;
    private String status;
    private String specialite;
    private Date date_embauche;
   @ManyToOne
   @JoinColumn(name = "departement")
   private Departement departement;
    @ManyToOne
    @JoinColumn(name = "grade")
    private Grade grade;

    @ManyToOne
    @JoinColumn(name = "matiere")
    private Matiere matiere;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "Enseignant-Matiere",
//    joinColumns = @JoinColumn(name = "id_matiere"),
//    inverseJoinColumns = @JoinColumn(name = "num_enseignant"))
//    private List<Matiere> listeMatieres;

    @OneToMany(mappedBy = "enseignant")
    private List<Cours> cours_deposes;
    @OneToMany(mappedBy = "proprietaireCong")
    private List<DemandeConges> demandesConges;

    @OneToMany(mappedBy = "proprietaireR")
    private List<DemandeRattrapage> demandesRattrapages;

    @OneToMany(mappedBy = "enseignant_et")
    private List<LigneEmploiEtude> lignes_emp_et;

    @OneToMany(mappedBy = "enseignant_ex")
    private List<LigneEmploiExamen> lignes_emp_ex;

    @OneToMany(mappedBy = "enseignant_R")
    private List<LigneEmploiRattrapage> lignes_emp_R;


}
