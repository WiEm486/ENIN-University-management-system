package Miniprojet.MiniProjetBackend.Block;

import Miniprojet.MiniProjetBackend.Salle.Salle;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
@Entity
public class Block {
    @Id
    private String id_block;
    private Integer nb_salles;
    @OneToMany(mappedBy = "block")
    private List<Salle> ListeSalles;

}
