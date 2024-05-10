package Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeConges;

import Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeAdministrative;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Date;
@RequiredArgsConstructor
@Data
@Entity
public class DemandeConges extends DemandeAdministrative {
    @Id
    @GeneratedValue(generator = "Dcong-generator")
    @GenericGenerator(name = "Dcong-generator",
            parameters = @Parameter(name = "prefix", value = "DemC"),
            strategy = "Miniprojet.MiniProjetBackend.MyGenerator")
    private String id_demandeC;
    @Column
    private Date jour_deb;
    @Column
    private Date jour_fin;
    @Column
    private String type;
    @ManyToOne
    @JoinColumn(name = "num_enseignant", nullable = false)
    private Enseignant proprietaireCong;

}
