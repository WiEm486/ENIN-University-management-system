package Miniprojet.MiniProjetBackend.Emploi.Examen;

import Miniprojet.MiniProjetBackend.Emploi.Etude.EmploiEtude;
import Miniprojet.MiniProjetBackend.LigneEmploi.Examen.LigneEmploiExamen;
import Miniprojet.MiniProjetBackend.LigneEmploi.Examen.LigneEmploiExamenDTO;
import Miniprojet.MiniProjetBackend.groupe.Groupe;
import Miniprojet.MiniProjetBackend.groupe.GroupeResponseDto;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class EmploiExamenDTO {
    private String id_emploi;
    private String annee_univ;
    private int seme;
    private List<GroupeResponseDto> groupes;
    private  List<LigneEmploiExamenDTO> lignes;
    public static EmploiExamenDTO fromEntity(EmploiExamen emploiExamen){
        EmploiExamenDTO emploiExamenDTO=new EmploiExamenDTO();
        emploiExamenDTO.setId_emploi(emploiExamen.getId_emploi());
        emploiExamenDTO.setSeme(emploiExamen.getSeme());
        emploiExamenDTO.setAnnee_univ(emploiExamen.getAnnee_univ());
        emploiExamenDTO.setGroupes(GroupeResponseDto.toDTOList(emploiExamen.getGroupes()));
        return emploiExamenDTO;
    }

    public EmploiExamen toEntity(){
        EmploiExamen emploiExamen=new EmploiExamen();
        emploiExamen.setId_emploi(this.getId_emploi());
        emploiExamen.setSeme(this.getSeme());
        emploiExamen.setAnnee_univ(this.getAnnee_univ());
        emploiExamen.setGroupes(GroupeResponseDto.toEntityList(this.getGroupes()));
        return emploiExamen;
    }

    public static List<EmploiExamenDTO> toDTOList(List<EmploiExamen> emploiExamens) {
        return emploiExamens.stream().map(EmploiExamenDTO::fromEntity).collect(Collectors.toList());
    }

    public static List<EmploiExamen> toEntityList(List<EmploiExamenDTO> dtos) {
        return dtos.stream().map(EmploiExamenDTO::toEntity).collect(Collectors.toList());
    }
}
