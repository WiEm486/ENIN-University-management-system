package Miniprojet.MiniProjetBackend.Emploi;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@RequiredArgsConstructor
@Data
@MappedSuperclass
public class Emploi {
    @Id
    @GeneratedValue(generator = "emploi-generator")
    @GenericGenerator(name = "emploi-generator",
            parameters = @Parameter(name = "prefix", value = "emp"),
            strategy = "Miniprojet.MiniProjetBackend.MyGenerator")
    private String id_emploi;

    @Column(name = "Année Universitaire")
    private String annee_univ;

    @Column(name = " semestre")
    private int seme;
}
