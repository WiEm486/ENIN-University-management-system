package Miniprojet.MiniProjetBackend.Profile.AdminEtudiant;

import Miniprojet.MiniProjetBackend.Profile.Profile;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
public class AdminEtudiant extends Profile {

    @Id
    private String CIN;


}
