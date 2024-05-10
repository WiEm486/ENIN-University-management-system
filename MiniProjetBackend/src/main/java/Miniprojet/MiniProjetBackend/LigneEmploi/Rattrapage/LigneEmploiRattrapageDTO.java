package Miniprojet.MiniProjetBackend.LigneEmploi.Rattrapage;


import Miniprojet.MiniProjetBackend.Emploi.Rattrapage.EmploiRattrapageDTO;
import Miniprojet.MiniProjetBackend.Ennumeration.Jour;
import Miniprojet.MiniProjetBackend.Ennumeration.TypeSeance;
import Miniprojet.MiniProjetBackend.Matiere.MatiereDTO;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.EnseignantDTO;
import Miniprojet.MiniProjetBackend.Salle.SalleDTO;
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
public class LigneEmploiRattrapageDTO {
    private String id_ligne_emp;
    @Enumerated
    private Jour jour;
    private LocalTime debut_seance;
    private LocalTime fin_seance;
    @Enumerated
    private TypeSeance type;
    private EmploiRattrapageDTO emploiR;
    private SalleDTO salle_R;
    private EnseignantDTO enseignant_R;
    private MatiereDTO matiere_R;

    public static LigneEmploiRattrapageDTO fromEntity(LigneEmploiRattrapage ligneEmploiRattrapage){
        LigneEmploiRattrapageDTO ligneEmploiRattrapageDTO=new LigneEmploiRattrapageDTO();
        ligneEmploiRattrapageDTO.setId_ligne_emp(ligneEmploiRattrapage.getId_ligne_emp());
        ligneEmploiRattrapageDTO.setJour(ligneEmploiRattrapage.getJour());
        ligneEmploiRattrapageDTO.setDebut_seance(ligneEmploiRattrapage.getDebut_seance());
        ligneEmploiRattrapageDTO.setFin_seance(ligneEmploiRattrapage.getFin_seance());
        ligneEmploiRattrapageDTO.setType(ligneEmploiRattrapage.getType());
        ligneEmploiRattrapageDTO.setEmploiR(EmploiRattrapageDTO.fromEntity(ligneEmploiRattrapage.getEmploiR()));
        ligneEmploiRattrapageDTO.setSalle_R(SalleDTO.fromEntity(ligneEmploiRattrapage.getSalle_R()));
        ligneEmploiRattrapageDTO.setEnseignant_R(EnseignantDTO.fromEntity(ligneEmploiRattrapage.getEnseignant_R()));
        ligneEmploiRattrapageDTO.setMatiere_R(MatiereDTO.fromEntity(ligneEmploiRattrapage.getMatiere_R()));
        return ligneEmploiRattrapageDTO;
    }

    public LigneEmploiRattrapage toEntity(){
        LigneEmploiRattrapage rattrapage=new LigneEmploiRattrapage();
        rattrapage.setId_ligne_emp(this.getId_ligne_emp());
        rattrapage.setJour(this.getJour());
        rattrapage.setDebut_seance(this.getDebut_seance());
        rattrapage.setFin_seance(this.getFin_seance());
        rattrapage.setType(this.getType());
        rattrapage.setEmploiR(this.getEmploiR().toEntity());
        rattrapage.setSalle_R(this.getSalle_R().toEntity());
        rattrapage.setEnseignant_R(this.getEnseignant_R().toEntity());
        rattrapage.setMatiere_R(this.getMatiere_R().toEntity());
        return rattrapage;
    }

    public static List<LigneEmploiRattrapageDTO> toDTOList(List<LigneEmploiRattrapage> ligneEmploiRattrapages) {
        return ligneEmploiRattrapages.stream().map(LigneEmploiRattrapageDTO::fromEntity).collect(Collectors.toList());
    }

    public static List<LigneEmploiRattrapage> toEntityList(List<LigneEmploiRattrapageDTO> dtos) {
        return dtos.stream().map(LigneEmploiRattrapageDTO::toEntity).collect(Collectors.toList());
    }
}
