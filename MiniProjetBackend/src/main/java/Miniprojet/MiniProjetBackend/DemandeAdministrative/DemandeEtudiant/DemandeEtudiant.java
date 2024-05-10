package Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeEtudiant;

import Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeAdministrative;
import Miniprojet.MiniProjetBackend.Profile.Etudiant.Etudiant;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@RequiredArgsConstructor
@Data
@Entity
public class DemandeEtudiant extends DemandeAdministrative {
    @Id
    @GeneratedValue(generator = "Detud-generator")
    @GenericGenerator(name = "Detud-generator",
            parameters = @Parameter(name = "prefix", value = "DemE"),
            strategy = "Miniprojet.MiniProjetBackend.MyGenerator")
    private String id_demandeE;
    @Column
    private String motif;
    @ManyToOne
    @JoinColumn(name = "num_inscription", nullable = false)
    private Etudiant proprietaireEtu;
}
