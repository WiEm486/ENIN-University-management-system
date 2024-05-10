package Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeEtudiant;

import Miniprojet.MiniProjetBackend.Ennumeration.StatusDemande;
import Miniprojet.MiniProjetBackend.Profile.Etudiant.Etudiant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class DemandeEtudiantDTO {
    private StatusDemande status;
    private String commentaire;
    private String motif;
    private Etudiant proprietaireEtu;

    public static DemandeEtudiantDTO fromEntity(DemandeEtudiant demandeEtudiant){
        DemandeEtudiantDTO demandeEtudiantDTO=new DemandeEtudiantDTO();
        demandeEtudiantDTO.setStatus(demandeEtudiant.getStatus());
        demandeEtudiantDTO.setCommentaire(demandeEtudiant.getCommentaire());
        demandeEtudiantDTO.setMotif(demandeEtudiant.getMotif());
        demandeEtudiantDTO.setProprietaireEtu(demandeEtudiant.getProprietaireEtu());
        return demandeEtudiantDTO;
    }

    public DemandeEtudiant toEntity(){
        DemandeEtudiant demandeEtudiant=new DemandeEtudiant();
        demandeEtudiant.setStatus(this.getStatus());
        demandeEtudiant.setCommentaire(this.getCommentaire());
        demandeEtudiant.setMotif(this.getMotif());
        demandeEtudiant.setProprietaireEtu(this.getProprietaireEtu());
        return demandeEtudiant;
    }
    public static List<DemandeEtudiantDTO> toDTOList(List<DemandeEtudiant> demandeEtudiants) {
        return demandeEtudiants.stream().map(DemandeEtudiantDTO::fromEntity).collect(Collectors.toList());
    }

    public static List<DemandeEtudiant> toEntityList(List<DemandeEtudiantDTO> dtos) {
        return dtos.stream().map(DemandeEtudiantDTO::toEntity).collect(Collectors.toList());
    }
}
