package Miniprojet.MiniProjetBackend.Profile;

import Miniprojet.MiniProjetBackend.Ennumeration.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDtoRequest {
    private String CIN;
    private String email;
    private String nom;
    private String prenom;
    private String mot_passe;
    private Date date_naissance;
    private Long num_tel;
    private String addresse;
    private String photo;
    @Enumerated(EnumType.STRING)
    private Role role;
}
