package Miniprojet.MiniProjetBackend.Salle;

import Miniprojet.MiniProjetBackend.Block.Block;
import Miniprojet.MiniProjetBackend.Block.BlockDTO;
import Miniprojet.MiniProjetBackend.Ennumeration.TypeSalle;
import Miniprojet.MiniProjetBackend.LigneEmploi.Etude.LigneEmploiEtudeDTO;
import Miniprojet.MiniProjetBackend.LigneEmploi.Examen.LigneEmploiExamenDTO;
import Miniprojet.MiniProjetBackend.LigneEmploi.Rattrapage.LigneEmploiRattrapageDTO;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class SalleDTO {
    private String id_salle;
    private String nom_salle;
    @Enumerated(EnumType.STRING)
    private TypeSalle type;
    private BlockDTO block;
    private List<LigneEmploiEtudeDTO> lignes_emploi_et;
    private List<LigneEmploiExamenDTO> lignes_emploi_ex;
    private List<LigneEmploiRattrapageDTO> lignes_emploi_R;

    public static SalleDTO fromEntity(Salle salle){
        SalleDTO salleDTO=new SalleDTO();
        salleDTO.setId_salle(salle.getId_salle());
        salleDTO.setNom_salle(salle.getNoms());
        salleDTO.setType(salle.getType());
        salleDTO.setBlock(BlockDTO.fromEntity(salle.getBlock()));
        //salleDTO.setLignes_emploi_et(LigneEmploiEtudeDTO.toDTOList(salle.getLignes_emploi_et()));
        //salleDTO.setLignes_emploi_R(LigneEmploiRattrapageDTO.toDTOList(salle.getLignes_emploi_R()));
        //salleDTO.setLignes_emploi_ex(LigneEmploiExamenDTO.toDTOList(salle.getLignes_emploi_ex()));
        return salleDTO;
    }
    public Salle toEntity(){
        Salle salle=new Salle();
        salle.setId_salle(this.getId_salle());
        salle.setNoms(this.getNom_salle());
        salle.setType(this.getType());
        salle.setBlock(this.getBlock().toEntity());
//        salle.setLignes_emploi_et(LigneEmploiEtudeDTO.toEntityList(this.getLignes_emploi_et()));
//        salle.setLignes_emploi_R(LigneEmploiRattrapageDTO.toEntityList(this.getLignes_emploi_R()));
//        salle.setLignes_emploi_ex(LigneEmploiExamenDTO.toEntityList(this.getLignes_emploi_ex()));
        return salle;
    }

    public static List<SalleDTO> toDTOList(List<Salle> salles) {
        return salles.stream().map(SalleDTO::fromEntity).collect(Collectors.toList());
    }
    public static List<Salle> toEntityList(List<SalleDTO> dtos) {
        return dtos.stream().map(SalleDTO::toEntity).collect(Collectors.toList());
    }
}