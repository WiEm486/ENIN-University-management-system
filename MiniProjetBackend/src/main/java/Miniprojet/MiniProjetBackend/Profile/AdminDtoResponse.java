package Miniprojet.MiniProjetBackend.Profile;

import Miniprojet.MiniProjetBackend.Ennumeration.Role;
import Miniprojet.MiniProjetBackend.Grade.Grade;
import Miniprojet.MiniProjetBackend.Grade.GradeDTO;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDtoResponse {
    private String CIN;
    private String email;
    private String nom;
    private String prenom;
    private Date date_naissance;
    private Long num_tel;
    private String addresse;
    private String photo;
    @Enumerated(EnumType.STRING)
    private Role role;

    // pour la consultation (à exécuter par le SuperAdmin)
    public static AdminDtoResponse fromEntity(Profile admin, Role role){
        return AdminDtoResponse.builder()
                .CIN(admin.getCIN())
                .email(admin.getEmail())
                .nom(admin.getNom())
                .prenom(admin.getPrenom())
                .date_naissance(admin.getDate_naissance())
                .addresse(admin.getAddresse())
                .num_tel(admin.getNum_tel())
                .photo(admin.getPhoto())
                .role(role)
                .build();
    }

    public static List<AdminDtoResponse> toDtoResponseList(List<Profile> admins, Role role) {
        return admins.stream()
                .map(admin -> fromEntity(admin, role))
                .collect(Collectors.toList());
    }
    public static List<Profile> toEntityList(List<AdminDtoResponse> dtos) {
        return dtos.stream().map(AdminDtoResponse::toEntity).collect(Collectors.toList());
    }

    private Profile toEntity() {
        Profile profile=new Profile();
        profile.setCIN(this.getCIN());
        profile.setNom(this.getNom());
        profile.setPrenom(this.getPrenom());
        profile.setEmail(this.getEmail());
        profile.setAddresse(this.getAddresse());
        profile.setDate_naissance(this.getDate_naissance());
        profile.setNum_tel(this.getNum_tel());
        profile.setPhoto(this.getPhoto());
        profile.setRole(this.getRole());
        return profile;
    }
}


