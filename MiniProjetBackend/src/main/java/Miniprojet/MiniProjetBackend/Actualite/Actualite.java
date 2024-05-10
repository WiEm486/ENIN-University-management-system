package Miniprojet.MiniProjetBackend.Actualite;

import Miniprojet.MiniProjetBackend.Ennumeration.CibleActualite;
import Miniprojet.MiniProjetBackend.Ennumeration.StatusActualite;
import Miniprojet.MiniProjetBackend.Ennumeration.TypeActualite;
import Miniprojet.MiniProjetBackend.Profile.Etudiant.Etudiant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.awt.*;
import java.util.Date;

@RequiredArgsConstructor
@Data
@Entity
public class Actualite {
    @Id
    @GeneratedValue(generator = "act-generator")
    @GenericGenerator(name = "act-generator",
            parameters = @Parameter(name = "prefix", value = "Act"),
            strategy = "Miniprojet.MiniProjetBackend.MyGenerator")
    private String id_actualité;
    @Column
    private String titre;
    @Column
    @Enumerated(EnumType.STRING)
    private TypeActualite type;
    @Column
    private Date date_publication;
    @Column
    private String contenu;
    @Column
    @Enumerated(EnumType.STRING)
    private CibleActualite cible;
    @Column
    @Enumerated(EnumType.STRING)
    private StatusActualite status;

}
