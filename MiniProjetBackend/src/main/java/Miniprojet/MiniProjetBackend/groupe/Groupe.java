package Miniprojet.MiniProjetBackend.groupe;

import Miniprojet.MiniProjetBackend.Emploi.Etude.EmploiEtude;
import Miniprojet.MiniProjetBackend.Emploi.Examen.EmploiExamen;
import Miniprojet.MiniProjetBackend.Emploi.Rattrapage.EmploiRattrapage;
import Miniprojet.MiniProjetBackend.Ennumeration.Niveau;
import Miniprojet.MiniProjetBackend.Profile.Etudiant.Etudiant;
import Miniprojet.MiniProjetBackend.Specialite.Specialite;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.List;
@Data
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Groupe {
    @Id
    @GeneratedValue(generator = "groupe-generator")
    @GenericGenerator(
            name = "groupe-generator",
            parameters = @Parameter(name = "prefix", value = "G"),
            strategy = "Miniprojet.MiniProjetBackend.MyGenerator"
    )
    private String id_groupe;
    private String nom;
    private Integer nb_etudiants;
    private Niveau niveau;
    @ManyToOne
    @JoinColumn(name = "nom_specialite", nullable = false)
    private Specialite speciality;

    @OneToMany(mappedBy = "groupe")
    protected List<Etudiant> etudiants;
    @OneToMany(mappedBy = "groupe")
    protected  List<EmploiEtude> emploi_etudes;
    @OneToMany(mappedBy = "groupe")
    protected  List<EmploiRattrapage> emploi_rattrapages;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "EmpExams_Group",
            joinColumns = @JoinColumn(name = "id_emploiEx"),
            inverseJoinColumns = @JoinColumn(name = "id_groupe")
    )
    protected  List<EmploiExamen> emplois_examens;

}
