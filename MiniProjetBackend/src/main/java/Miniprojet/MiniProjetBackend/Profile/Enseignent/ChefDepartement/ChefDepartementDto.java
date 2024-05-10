package Miniprojet.MiniProjetBackend.Profile.Enseignent.ChefDepartement;

import Miniprojet.MiniProjetBackend.Departement.Departement;
import Miniprojet.MiniProjetBackend.Ennumeration.Role;
import Miniprojet.MiniProjetBackend.Profile.AdminDto;
import Miniprojet.MiniProjetBackend.Profile.AdminScolarite.AdminScolarite;
import Miniprojet.MiniProjetBackend.Profile.AdminScolarite.AdminScolariteDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ChefDepartementDto {
    private String CIN;
    private String email;
    private String nom;
    private String prenom;
    private String password;
    private Date date_naissance;
    private Long num_tel;
    private String addresse;
    private String photo;
    private String num_enseignant;
    private String status;
    private String specialite;
    private Date date_embauche;
    private String departement;
    private String grade;
    private Date date_nomination;


    public AdminDto toAdminDto(){
        AdminDto admin = new AdminDto();
        admin.setCIN(this.CIN);
        admin.setEmail(this.email);
        admin.setNom(this.nom);
        admin.setPrenom(this.prenom);
        admin.setRole(Role.CHEF_DEPARTEMENT);
        return admin ;
    }

    public static ChefDepartementDto fromEntity(ChefDepartement admin) {
        ChefDepartementDto DTO = new ChefDepartementDto();
        DTO.setCIN(admin.getCIN());
        DTO.setEmail(admin.getEmail());
        DTO.setNom(admin.getNom());
        DTO.setPrenom(admin.getPrenom());
        DTO.setPassword(admin.getPassword());
        DTO.setDate_naissance(admin.getDate_naissance());
        DTO.setNum_tel(admin.getNum_tel());
        DTO.setAddresse(admin.getAddresse());
        return DTO;
    }

    public ChefDepartement toEntity() {
        ChefDepartement admin = new ChefDepartement();
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

    public static List<ChefDepartementDto> toDTOList(List<ChefDepartement> admins) {
        return admins.stream().map(ChefDepartementDto::fromEntity).collect(Collectors.toList());
    }


}