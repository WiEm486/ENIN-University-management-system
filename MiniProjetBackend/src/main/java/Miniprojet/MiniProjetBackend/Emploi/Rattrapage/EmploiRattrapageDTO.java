package Miniprojet.MiniProjetBackend.Emploi.Rattrapage;

import Miniprojet.MiniProjetBackend.LigneEmploi.Rattrapage.LigneEmploiRattrapageDTO;
import Miniprojet.MiniProjetBackend.groupe.GroupeResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class EmploiRattrapageDTO {
    private String id_emploi;
    private String annee_univ;
    private int seme;
    private GroupeResponseDto groupe;
    private List<LigneEmploiRattrapageDTO> lignes;
    public static EmploiRattrapageDTO fromEntity(EmploiRattrapage emploiRattrapage){
        EmploiRattrapageDTO emploiRattrapageDTO=new EmploiRattrapageDTO();
        emploiRattrapageDTO.setId_emploi(emploiRattrapage.getId_emploi());
        emploiRattrapageDTO.setSeme(emploiRattrapage.getSeme());
        emploiRattrapage.setAnnee_univ(emploiRattrapage.getAnnee_univ());
        emploiRattrapageDTO.setGroupe(GroupeResponseDto.Entity2Dto(emploiRattrapage.getGroupe()));
        emploiRattrapageDTO.setLignes(LigneEmploiRattrapageDTO.toDTOList(emploiRattrapage.getLignes()));
        return emploiRattrapageDTO;
    }

    public EmploiRattrapage toEntity(){
        EmploiRattrapage rattrapage=new EmploiRattrapage();
        rattrapage.setId_emploi(this.getId_emploi());
        rattrapage.setSeme(this.getSeme());
        rattrapage.setAnnee_univ(this.getAnnee_univ());
        rattrapage.setGroupe(this.getGroupe().toEntity());
        rattrapage.setLignes(LigneEmploiRattrapageDTO.toEntityList(this.getLignes()));
        return null;
    }

    public static List<EmploiRattrapageDTO> toDTOList(List<EmploiRattrapage> emploiRattrapages) {
        return emploiRattrapages.stream().map(EmploiRattrapageDTO::fromEntity).collect(Collectors.toList());
    }

    public static List<EmploiRattrapage> toEntityList(List<EmploiRattrapageDTO> dtos) {
        return dtos.stream().map(EmploiRattrapageDTO::toEntity).collect(Collectors.toList());
    }
}
