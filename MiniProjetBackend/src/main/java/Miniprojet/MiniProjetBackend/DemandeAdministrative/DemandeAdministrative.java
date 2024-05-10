package Miniprojet.MiniProjetBackend.DemandeAdministrative;

import Miniprojet.MiniProjetBackend.Ennumeration.StatusDemande;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@RequiredArgsConstructor
@Data
@MappedSuperclass
public class DemandeAdministrative {
    @Column
    @Enumerated(EnumType.STRING)
    private StatusDemande status;
    @Column
    private String commentaire;

}
