package Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeConges;


import Miniprojet.MiniProjetBackend.Ennumeration.StatusDemande;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class DemandeCongesDTO {
    private StatusDemande status;
    private String commentaire;
    private Date jour_deb;
    private Date jour_fin;
    private String type;
    private Enseignant proprietaireCong;

    public static DemandeCongesDTO fromEntity(DemandeConges demandeConges){
        DemandeCongesDTO congesDTO=new DemandeCongesDTO();
        congesDTO.setStatus(demandeConges.getStatus());
        congesDTO.setCommentaire(demandeConges.getCommentaire());
        congesDTO.setJour_deb(demandeConges.getJour_deb());
        congesDTO.setJour_fin(demandeConges.getJour_fin());
        congesDTO.setType(demandeConges.getType());
        congesDTO.setProprietaireCong(demandeConges.getProprietaireCong());
        return congesDTO;
    }

    public DemandeConges toEntity(){
        DemandeConges conges=new DemandeConges();
        conges.setStatus(this.getStatus());
        conges.setCommentaire(this.getCommentaire());
        conges.setJour_deb(this.getJour_deb());
        conges.setJour_fin(this.getJour_fin());
        conges.setType(this.getType());
        conges.setProprietaireCong(this.getProprietaireCong());
        return conges;
    }
    public static List<DemandeCongesDTO> toDTOList(List<DemandeConges> demandeConges) {
        return demandeConges.stream().map(DemandeCongesDTO::fromEntity).collect(Collectors.toList());
    }

    public static List<DemandeConges> toEntityList(List<DemandeCongesDTO> dtos) {
        return dtos.stream().map(DemandeCongesDTO::toEntity).collect(Collectors.toList());
    }
}
