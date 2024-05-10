package Miniprojet.MiniProjetBackend.Emploi.Etude;

import Miniprojet.MiniProjetBackend.LigneEmploi.Etude.LigneEmploiEtude;
import Miniprojet.MiniProjetBackend.LigneEmploi.Etude.LigneEmploiEtudeDTO;
import Miniprojet.MiniProjetBackend.groupe.Groupe;
import Miniprojet.MiniProjetBackend.groupe.GroupeResponseDto;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class EmploiEtudeDTO {
    private String id_emploi;
    private String annee_univ;
    private int seme;
    private GroupeResponseDto groupe;
    private  List<LigneEmploiEtudeDTO> lignes;
    public static EmploiEtudeDTO fromEntity(EmploiEtude emploiEtude){
        EmploiEtudeDTO emploiEtudeDTO=new EmploiEtudeDTO();
        emploiEtudeDTO.setId_emploi(emploiEtude.getId_emploi());
        emploiEtudeDTO.setSeme(emploiEtude.getSeme());
        emploiEtudeDTO.setAnnee_univ(emploiEtude.getAnnee_univ());
        emploiEtudeDTO.setGroupe(GroupeResponseDto.Entity2Dto(emploiEtude.getGroupe()));
        emploiEtudeDTO.setLignes(LigneEmploiEtudeDTO.toDTOList(emploiEtude.getLignes()));
        return emploiEtudeDTO;
    }

    public EmploiEtude toEntity(){
        EmploiEtude emploiEtude=new EmploiEtude();
        emploiEtude.setId_emploi(this.getId_emploi());
        emploiEtude.setSeme(this.getSeme());
        emploiEtude.setAnnee_univ(this.getAnnee_univ());
        emploiEtude.setGroupe(this.getGroupe().toEntity());
        //emploiEtude.setLignes(LigneEmploiEtudeDTO.toEntityList(this.getLignes()));
        return emploiEtude;
    }

    public static List<EmploiEtudeDTO> toDTOList(List<EmploiEtude> emploiEtudes) {
        return emploiEtudes.stream().map(EmploiEtudeDTO::fromEntity).collect(Collectors.toList());
    }

    public static List<EmploiEtude> toEntityList(List<EmploiEtudeDTO> dtos) {
        return dtos.stream().map(EmploiEtudeDTO::toEntity).collect(Collectors.toList());
    }
}
