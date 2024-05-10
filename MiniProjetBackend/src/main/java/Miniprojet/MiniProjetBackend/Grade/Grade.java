package Miniprojet.MiniProjetBackend.Grade;

import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
@Data
@Entity
public class Grade {
    @Id
    private String grade;
    @Column
    private String description;
    @Column
    private Integer charge_horaire;
    @OneToMany(mappedBy = "grade")
    private List<Enseignant> listeEnseignants;

}
