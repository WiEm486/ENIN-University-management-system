package Miniprojet.MiniProjetBackend.Grade;

import Miniprojet.MiniProjetBackend.Block.Block;
import Miniprojet.MiniProjetBackend.Block.BlockDTO;
import Miniprojet.MiniProjetBackend.Cours.Cours;
import Miniprojet.MiniProjetBackend.Cours.CoursDTO;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.EnseignantDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class GradeDTO {
    private String grade;
    private String description;
    private Integer charge_horaire;
    private List<EnseignantDTO> listeEnseignants;

    public static GradeDTO fromEntity(Grade grade) {
        GradeDTO gradeDTO=new GradeDTO();
        gradeDTO.setGrade(grade.getGrade());
        gradeDTO.setDescription(grade.getDescription());
        gradeDTO.setCharge_horaire(grade.getCharge_horaire());
        gradeDTO.setListeEnseignants(EnseignantDTO.toDTOList(grade.getListeEnseignants()));
        return gradeDTO;
    }
    public Grade toEntity(){
        Grade grade=new Grade();
        grade.setGrade(this.getGrade());
        grade.setDescription(this.getDescription());
        grade.setCharge_horaire(this.getCharge_horaire());
        grade.setListeEnseignants(EnseignantDTO.toEntityList(this.getListeEnseignants()));
        return grade;
    }
    public static List<GradeDTO> toDTOList(List<Grade> grades) {
        return grades.stream().map(GradeDTO::fromEntity).collect(Collectors.toList());
    }
    public static List<Grade> toEntityList(List<GradeDTO> dtos) {
        return dtos.stream().map(GradeDTO::toEntity).collect(Collectors.toList());
    }
}
