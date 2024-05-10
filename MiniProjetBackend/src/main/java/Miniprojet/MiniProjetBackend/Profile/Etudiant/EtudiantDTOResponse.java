package Miniprojet.MiniProjetBackend.Profile.Etudiant;

import Miniprojet.MiniProjetBackend.Ennumeration.Role;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class EtudiantDTOResponse {
    private String num_inscription;
    private String CIN;
    private String email;
     private String nom;
     private String prenom;
     private Date date_naissance;
    private Long num_tel;
    private String addresse;
    private String groupe;
     private String photo;
     private Role role;


    public static EtudiantDTOResponse Entity2Dto(Etudiant etudiant){
        return EtudiantDTOResponse.builder()
                .num_inscription(etudiant.getNum_inscription())
                .CIN(etudiant.getCIN())
                .email(etudiant.getEmail())
                .nom(etudiant.getNom())
                .prenom(etudiant.getPrenom())
                .date_naissance(etudiant.getDate_naissance())
                .addresse(etudiant.getAddresse())
                .num_tel(etudiant.getNum_tel())
                .photo(etudiant.getPhoto())
                .groupe(etudiant.getGroupe().getNom())
                .role(Role.ETUDIANT)
                .build();
    }


    public static List<EtudiantDTOResponse> toDtoResponseList(List<Etudiant> etudiants) {
        return etudiants.stream()
                .map(etudiant -> Entity2Dto(etudiant))
                .collect(Collectors.toList());
    }
}
