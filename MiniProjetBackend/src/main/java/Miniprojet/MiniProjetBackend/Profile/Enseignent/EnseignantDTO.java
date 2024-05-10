package Miniprojet.MiniProjetBackend.Profile.Enseignent;

import Miniprojet.MiniProjetBackend.Departement.Departement;
import Miniprojet.MiniProjetBackend.Emploi.Etude.EmploiEtude;
import Miniprojet.MiniProjetBackend.Emploi.Etude.EmploiEtudeDTO;
import Miniprojet.MiniProjetBackend.Ennumeration.Role;
import Miniprojet.MiniProjetBackend.Grade.Grade;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Data
public class EnseignantDTO {
    private String CIN;
    private String email;
    private String nom;
    private String prenom;
    private String password;
    private Date date_naissance;
    private Long num_tel;
    private String addresse;
    private String photo;
    private Role role;
    private String num_enseignant;
    private String specialite;
    private Date date_embauche;
    private String departement;
    private String grade;
    private String matiere;

    //photo nom+ prénom  departement grade

    public static EnseignantDTO fromEntity(Enseignant enseignant) {
        EnseignantDTO dto = new EnseignantDTO();
        dto.setCIN(enseignant.getCIN());
        dto.setPhoto(enseignant.getPhoto());
        dto.setNom(enseignant.getNom());
        dto.setDepartement(enseignant.getDepartement().getDepartement());
        dto.setGrade(enseignant.getGrade().getGrade());
        dto.setMatiere(enseignant.getMatiere().getNom());
        return dto;
    }
    public Enseignant toEntity(){
        return null;
    }

    public static List<EnseignantDTO> toDTOList(List<Enseignant> enseignants) {
        return enseignants.stream().map(EnseignantDTO::fromEntity).collect(Collectors.toList());
    }

    public static List<Enseignant> toEntityList(List<EnseignantDTO> dtos) {
        return dtos.stream().map(EnseignantDTO::toEntity).collect(Collectors.toList());
    }
}
