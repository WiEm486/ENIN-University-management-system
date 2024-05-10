package Miniprojet.MiniProjetBackend.groupe;

import Miniprojet.MiniProjetBackend.Cours.Cours;
import Miniprojet.MiniProjetBackend.Cours.CoursDTO;
import Miniprojet.MiniProjetBackend.Emploi.Examen.EmploiExamen;
import Miniprojet.MiniProjetBackend.Emploi.Examen.EmploiExamenDTO;
import Miniprojet.MiniProjetBackend.Ennumeration.Niveau;
import Miniprojet.MiniProjetBackend.Profile.Etudiant.EtudiantDTOResponse;
import Miniprojet.MiniProjetBackend.Specialite.Specialite;
import Miniprojet.MiniProjetBackend.Specialite.SpecialiteResponseDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class GroupeResponseDto {
    public String id_groupe;
    public String nom_groupe;
    public Integer nb_etudiants;
    public Specialite speciality;
    public Niveau niveau;
    public List<EtudiantDTOResponse> etudiants;

    public static GroupeResponseDto Entity2Dto(Groupe groupe) {
        GroupeResponseDto Dto = new GroupeResponseDto();
        Dto.setId_groupe(groupe.getId_groupe());
        Dto.setNom_groupe(groupe.getNom());
        Dto.setNb_etudiants(groupe.getNb_etudiants());
        Dto.setSpeciality(SpecialiteResponseDto.Entity2Dto(groupe.getSpeciality()));
        Dto.setNiveau(groupe.getNiveau());
        Dto.setEtudiants(groupe.getEtudiants().stream()
                .map(EtudiantDTOResponse::Entity2Dto)
                .collect(Collectors.toList()));
        return Dto;
    }

    public static GroupeResponseDto fromEntity(Groupe groupe) {
        GroupeResponseDto groupeResponseDto=new GroupeResponseDto();
        groupeResponseDto.setId_groupe(groupe.getId_groupe());
        groupeResponseDto.setNom_groupe(groupe.getNom());
        groupeResponseDto.setNiveau(groupe.getNiveau());
        groupeResponseDto.setSpeciality(groupe.getSpeciality());
        groupeResponseDto.setNb_etudiants(groupe.getNb_etudiants());
        groupeResponseDto.setEtudiants(EtudiantDTOResponse.toDtoResponseList(groupe.getEtudiants()));
        return groupeResponseDto;
    }
    public  Groupe toEntity() {
        Groupe groupe=new Groupe();
        groupe.setId_groupe(this.getId_groupe());
        groupe.setNom(this.getNom_groupe());
        groupe.setNiveau(this.getNiveau());
        groupe.setNb_etudiants(this.getNb_etudiants());
        return groupe;
    }
    public static List<GroupeResponseDto> toDTOList(List<Groupe> groupes) {
        return groupes.stream().map(GroupeResponseDto::fromEntity).collect(Collectors.toList());
    }

    public static List<Groupe> toEntityList(List<GroupeResponseDto> dtos) {
        return dtos.stream().map(GroupeResponseDto::toEntity).collect(Collectors.toList());
    }

}
