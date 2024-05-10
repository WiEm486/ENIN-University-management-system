package Miniprojet.MiniProjetBackend.Emploi.Examen;

import Miniprojet.MiniProjetBackend.Emploi.Emploi;
import Miniprojet.MiniProjetBackend.LigneEmploi.Examen.LigneEmploiExamen;
import Miniprojet.MiniProjetBackend.groupe.Groupe;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
@Entity
public class EmploiExamen extends Emploi {
    @ManyToMany(mappedBy = "emplois_examens")
    private List<Groupe> groupes;
    @OneToMany(mappedBy = "emploiEx")
    private  List<LigneEmploiExamen> lignes;
}
