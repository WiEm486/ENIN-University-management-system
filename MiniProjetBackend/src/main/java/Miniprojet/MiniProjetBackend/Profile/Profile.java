package Miniprojet.MiniProjetBackend.Profile;


import Miniprojet.MiniProjetBackend.Ennumeration.Role;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Profile {
    @Id
    private String CIN ;
    private String email;

    private String nom;

    private String prenom;

    private String password;

    private Date date_naissance;

    private Long num_tel;
    private String addresse;

    private String photo;
    @Enumerated(EnumType.STRING)
    protected Role role;


}
