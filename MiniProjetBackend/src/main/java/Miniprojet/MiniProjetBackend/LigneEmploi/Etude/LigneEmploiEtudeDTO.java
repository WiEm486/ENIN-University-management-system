package Miniprojet.MiniProjetBackend.LigneEmploi.Etude;

import Miniprojet.MiniProjetBackend.Emploi.Etude.EmploiEtudeDTO;
import Miniprojet.MiniProjetBackend.Ennumeration.Jour;
import Miniprojet.MiniProjetBackend.Ennumeration.Regime;
import Miniprojet.MiniProjetBackend.Ennumeration.TypeSeance;
import Miniprojet.MiniProjetBackend.Matiere.MatiereDTO;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.EnseignantDTO;
import Miniprojet.MiniProjetBackend.Salle.SalleDTO;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class LigneEmploiEtudeDTO {
    private String id_ligne_emp;
    @Enumerated(EnumType.STRING)
    private Jour jour;
    private LocalTime debut_seance;
    private LocalTime fin_seance;
    private Regime regime;
    @Enumerated(EnumType.STRING)
    private TypeSeance type;
    private String emploiEt;
    // Les noms
    private String salle_et;
    private String enseignant_et;
    private String matiere_et;

    public static LigneEmploiEtudeDTO fromEntity(LigneEmploiEtude ligneEmploiEtude){
        LigneEmploiEtudeDTO ligneEmploiEtudeDTO=new LigneEmploiEtudeDTO();
        ligneEmploiEtudeDTO.setId_ligne_emp(ligneEmploiEtude.getId_ligne_emp());
        ligneEmploiEtudeDTO.setDebut_seance(ligneEmploiEtude.getDebut_seance());
        ligneEmploiEtudeDTO.setFin_seance(ligneEmploiEtude.getFin_seance());
        ligneEmploiEtudeDTO.setRegime(ligneEmploiEtude.getRegime());
        ligneEmploiEtudeDTO.setType(ligneEmploiEtude.getType());
        //ligneEmploiEtudeDTO.setEmploiEt(EmploiEtudeDTO.fromEntity(ligneEmploiEtude.getEmploiEt()));
        ligneEmploiEtudeDTO.setSalle_et(ligneEmploiEtude.getSalle_et().getNoms());
        ligneEmploiEtudeDTO.setEnseignant_et(ligneEmploiEtude.getEnseignant_et().getNom());
        ligneEmploiEtudeDTO.setMatiere_et(ligneEmploiEtude.getMatiere_et().getNom());
        return ligneEmploiEtudeDTO;
    }

    /*public LigneEmploiEtude toEntity(){
        LigneEmploiEtude ligneEmploiEtude=new LigneEmploiEtude();
        ligneEmploiEtude.setId_ligne_emp(this.getId_ligne_emp());
        ligneEmploiEtude.setDebut_seance(this.getDebut_seance());
        ligneEmploiEtude.setFin_seance(this.getFin_seance());
        ligneEmploiEtude.setRegime(this.getRegime());
        ligneEmploiEtude.setType(this.getType());
        ligneEmploiEtude.setEmploiEt(this.getEmploiEt().toEntity());
        ligneEmploiEtude.setSalle_et(this.getSalle_et().toEntity());
        ligneEmploiEtude.setEnseignant_et(this.getEnseignant_et().toEntity());
        ligneEmploiEtude.setMatiere_et(this.getMatiere_et().toEntity());
        return ligneEmploiEtude;
    }*/

    public static List<LigneEmploiEtudeDTO> toDTOList(List<LigneEmploiEtude> ligneEmploiEtudes) {
        return ligneEmploiEtudes.stream().map(LigneEmploiEtudeDTO::fromEntity).collect(Collectors.toList());
    }

//    public static List<LigneEmploiEtude> toEntityList(List<LigneEmploiEtudeDTO> dtos) {
//        return dtos.stream().map(LigneEmploiEtudeDTO::toEntity).collect(Collectors.toList());
//    }
}
