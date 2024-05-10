package Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeRattrapage;


import Miniprojet.MiniProjetBackend.Ennumeration.Jour;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class DemandeRattrapageDTO {
    private String status;
    private String commentaire;
    private String jour;
    private LocalTime debut;
    private LocalTime fin;
    //Nom_enseignant
    private String proprietaireR;
    //Groupe
    private String nom_groupe;
    //Matiere
    private String matiere;

    public static DemandeRattrapageDTO fromEntity(DemandeRattrapage demandeRattrapage) {
        DemandeRattrapageDTO rattrapageDTO = new DemandeRattrapageDTO();
        rattrapageDTO.setStatus(demandeRattrapage.getStatus().getStringValue());
        rattrapageDTO.setCommentaire(demandeRattrapage.getCommentaire());
        rattrapageDTO.setJour(demandeRattrapage.getJour().getStringValue());
        rattrapageDTO.setDebut(demandeRattrapage.getDebut());
        rattrapageDTO.setFin(demandeRattrapage.getFin());
        rattrapageDTO.setProprietaireR(demandeRattrapage.getProprietaireR().getNom());
        rattrapageDTO.setMatiere(demandeRattrapage.getMatiere().getNom());
        rattrapageDTO.setNom_groupe(demandeRattrapage.getGroupe().getNom());
        return rattrapageDTO;
    }


    public static List<DemandeRattrapageDTO> toDTOList(List<DemandeRattrapage> demandeRattrapages) {
        return demandeRattrapages.stream().map(DemandeRattrapageDTO::fromEntity).collect(Collectors.toList());
    }

}
