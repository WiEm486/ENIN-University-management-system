package Miniprojet.MiniProjetBackend.Actualite;

import Miniprojet.MiniProjetBackend.Ennumeration.CibleActualite;
import Miniprojet.MiniProjetBackend.Ennumeration.StatusActualite;
import Miniprojet.MiniProjetBackend.Ennumeration.TypeActualite;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class ActualiteDTO {
    private String titre;
    private String type;
    private Date date_publication;
    private String contenu;
    private String cible;
    private String status;

    public static ActualiteDTO fromEntity(Actualite actualite) {
        ActualiteDTO actualiteDTO=new ActualiteDTO();
        actualiteDTO.setTitre(actualite.getTitre());
        actualiteDTO.setType(actualite.getType().getStringValue());
        actualiteDTO.setDate_publication(actualite.getDate_publication());
        actualiteDTO.setStatus(actualite.getStatus().getStringValue());
        actualiteDTO.setCible(actualite.getCible().getStringValue());
        return actualiteDTO;
    }
    public Actualite toEntity(){
        Actualite actualite=new Actualite();
        actualite.setTitre(this.getTitre());
        actualite.setType(TypeActualite.fromString(this.getType()));
        actualite.setDate_publication(this.getDate_publication());
        actualite.setStatus(StatusActualite.fromString(this.getStatus()));
        actualite.setCible(CibleActualite.fromString(this.getCible()));
        actualite.setContenu(this.getContenu());
        return actualite;
    }
    // Static method to convert list of entities to list of DTOs
    public static List<ActualiteDTO> toDTOList(List<Actualite> actualites) {
        return actualites.stream().map(ActualiteDTO::fromEntity).collect(Collectors.toList());
    }
    public static List<Actualite> toEntityList(List<ActualiteDTO> dtos) {
        return dtos.stream().map(ActualiteDTO::toEntity).collect(Collectors.toList());
    }

}
