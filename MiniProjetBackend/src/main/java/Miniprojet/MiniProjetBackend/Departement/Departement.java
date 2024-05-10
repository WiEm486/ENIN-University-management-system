package Miniprojet.MiniProjetBackend.Departement;

import Miniprojet.MiniProjetBackend.Profile.Enseignent.ChefDepartement.ChefDepartement;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import Miniprojet.MiniProjetBackend.Specialite.Specialite;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
@Entity
public class Departement {
    @Id
    private String departement;
    private String description;
    @OneToMany(mappedBy = "departement")
    private List<Enseignant> listeEnseignants;
    @OneToOne
    private ChefDepartement chef;
    @OneToMany(mappedBy = "departement")
    private List<Specialite> listeSpecialites;

}
