package Miniprojet.MiniProjetBackend.Cours;


import Miniprojet.MiniProjetBackend.Matiere.Matiere;
import Miniprojet.MiniProjetBackend.Matiere.MatiereDTO;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.EnseignantDTO;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CoursDTO {
    private String id_cours;
    private  String contenu;
    private Date date_depot;
    private String matiere;
    private String enseignant;

    public static CoursDTO fromEntity(Cours cours) {
        CoursDTO coursDTO=new CoursDTO();
        coursDTO.setId_cours(cours.getId_cours());
        coursDTO.setContenu(cours.getContenu());
        coursDTO.setDate_depot(cours.getDate_depot());
        coursDTO.setEnseignant(cours.getEnseignant().getNom());
        coursDTO.setMatiere(cours.getMatiere().getNom());
        return coursDTO;
    }

    public Cours toEntity(){
        Cours cours=new Cours();
        cours.setId_cours(this.id_cours);
        cours.setContenu(this.getContenu());
        cours.setDate_depot(this.getDate_depot());
        //cours.setEnseignant(this.getEnseignant().toEntity());
        //cours.setMatiere(this.getMatiere().toEntity());
        return cours;
    }
    // Static method to convert list of entities to list of DTOs
    public static List<CoursDTO> toDTOList(List<Cours> cours) {
        return cours.stream().map(CoursDTO::fromEntity).collect(Collectors.toList());
    }

    public static List<Cours> toEntityList(List<CoursDTO> dtos) {
        return dtos.stream().map(CoursDTO::toEntity).collect(Collectors.toList());
    }


}
