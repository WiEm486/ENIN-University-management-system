package Miniprojet.MiniProjetBackend.Profile.Enseignent.ChefDepartement;

import Miniprojet.MiniProjetBackend.Departement.Departement;
import Miniprojet.MiniProjetBackend.Ennumeration.Role;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class ChefDepartement extends Enseignant {
    private Date date_nomination;
    @OneToOne(mappedBy = "chef")
    private Departement departement;

}
