package Miniprojet.MiniProjetBackend.Profile;

import Miniprojet.MiniProjetBackend.Ennumeration.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AdminDto {
    private String CIN;
    private String email;
    private String nom;
    private String prenom;
    private Role role;


}
