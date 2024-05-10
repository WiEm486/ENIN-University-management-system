package Miniprojet.MiniProjetBackend.LigneEmploi;

import Miniprojet.MiniProjetBackend.Ennumeration.Jour;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.time.LocalTime;

@RequiredArgsConstructor
@Data
@MappedSuperclass
public class LigneEmploi {
    @Id
    @GeneratedValue(generator = "LE-generator")
    @GenericGenerator(name = "LE-generator",
            parameters = @Parameter(name = "prefix", value = "LE"),
            strategy = "Miniprojet.MiniProjetBackend.MyGenerator")
    private String id_ligne_emp;
    @Column(name = "Jour")
    @Enumerated(EnumType.STRING)
    private Jour jour;
    @Column(name = "debut")
    private LocalTime debut_seance;
    @Column(name = "fin")
    private LocalTime fin_seance;

}
