package Miniprojet.MiniProjetBackend.Specialite;

import Miniprojet.MiniProjetBackend.Departement.Departement;
import Miniprojet.MiniProjetBackend.groupe.Groupe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Specialite {
    @Id
    private String nom_specialite;

    private String description;
    @ManyToOne
    @JoinColumn(name = "departement", nullable = false)
    private Departement departement;
    @OneToMany(mappedBy = "speciality")
    private List<Groupe> listeGroupes;

}
