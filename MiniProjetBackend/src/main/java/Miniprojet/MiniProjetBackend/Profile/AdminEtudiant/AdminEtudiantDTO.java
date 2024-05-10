package Miniprojet.MiniProjetBackend.Profile.AdminEtudiant;

import Miniprojet.MiniProjetBackend.Ennumeration.Role;
import Miniprojet.MiniProjetBackend.Profile.AdminDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@RequiredArgsConstructor
public class AdminEtudiantDTO {
        private String CIN;
        private String email;
        private String nom;
        private String prenom;
        private String password;
        private Date date_naissance;
        private Long num_tel;
        private String addresse;
        private String photo="";

        // Static method to convert from entity to DTO
        public static AdminEtudiantDTO fromEntity(AdminEtudiant admin) {
            AdminEtudiantDTO DTO = new AdminEtudiantDTO();
            DTO.setCIN(admin.getCIN());
            DTO.setEmail(admin.getEmail());
            DTO.setNom(admin.getNom());
            DTO.setPrenom(admin.getPrenom());
            DTO.setPassword(admin.getPassword());
            DTO.setDate_naissance(admin.getDate_naissance());
            DTO.setNum_tel(admin.getNum_tel());
            DTO.setAddresse(admin.getAddresse());
            DTO.setPhoto(admin.getPhoto());
            return DTO;
        }

        // Static method to convert from DTO to entity
        public AdminEtudiant toEntity() {
            AdminEtudiant admin = new AdminEtudiant();
            admin.setCIN(this.getCIN());
            admin.setEmail(this.getEmail());
            admin.setNom(this.getNom());
            admin.setPrenom(this.getPrenom());
            admin.setPassword(this.getPassword());
            admin.setDate_naissance(this.getDate_naissance());
            admin.setNum_tel(this.getNum_tel());
            admin.setAddresse(this.getAddresse());
            admin.setPhoto(this.getPhoto());
            return admin;
        }

        // Static method to convert list of entities to list of DTOs
        public static List<AdminEtudiantDTO> toDTOList(List<AdminEtudiant> admins) {
            return admins.stream().map(AdminEtudiantDTO::fromEntity).collect(Collectors.toList());
        }

    public AdminDto toAdminDto(){
        AdminDto admin = new AdminDto();
        admin.setCIN(this.CIN);
        admin.setEmail(this.email);
        admin.setNom(this.nom);
        admin.setPrenom(this.prenom);
        admin.setRole(Role.ADMIN_ETUDIANT);
        return admin ;
    }


}
