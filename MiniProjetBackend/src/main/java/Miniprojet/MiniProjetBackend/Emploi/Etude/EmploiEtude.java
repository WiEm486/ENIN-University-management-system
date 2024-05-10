package Miniprojet.MiniProjetBackend.Emploi.Etude;

import Miniprojet.MiniProjetBackend.Emploi.Emploi;
import Miniprojet.MiniProjetBackend.LigneEmploi.Etude.LigneEmploiEtude;
import Miniprojet.MiniProjetBackend.groupe.Groupe;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
@Data
@Entity
public class EmploiEtude extends Emploi {
    @ManyToOne
    @JoinColumn(name = "id_groupe", nullable = false)
    private Groupe groupe;
    @OneToMany(mappedBy = "emploiEt")
    private  List<LigneEmploiEtude> lignes;
}
