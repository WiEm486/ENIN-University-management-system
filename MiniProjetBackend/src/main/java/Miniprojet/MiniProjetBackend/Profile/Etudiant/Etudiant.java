package Miniprojet.MiniProjetBackend.Profile.Etudiant;

import Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeEtudiant.DemandeEtudiant;
import Miniprojet.MiniProjetBackend.Profile.Profile;
import Miniprojet.MiniProjetBackend.RapportDeStage.RapportDeStage;
import Miniprojet.MiniProjetBackend.groupe.Groupe;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Etudiant extends Profile {
    @Column
    public String num_inscription;
    @ManyToOne
    @JoinColumn(name="id_groupe", nullable = false)
    public Groupe groupe;

    @OneToMany(mappedBy = "proprietaireEtu")
    public List<DemandeEtudiant> demandes ;

    @OneToMany(mappedBy = "proprietaire")
    private List<RapportDeStage> rapports;


}
