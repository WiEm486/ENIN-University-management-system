package Miniprojet.MiniProjetBackend.Suivi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity
@IdClass(SuiviId.class)
public class Suivi {
    @Id
    private String num_inscription;
    @Id
    private String id_matiere;
    private Integer nb_absence;
    private Float note_ds;
    private Float note_tp;
    private Float note_examen;

}
