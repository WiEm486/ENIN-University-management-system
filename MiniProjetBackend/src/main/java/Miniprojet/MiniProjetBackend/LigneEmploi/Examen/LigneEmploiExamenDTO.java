package Miniprojet.MiniProjetBackend.LigneEmploi.Examen;


import Miniprojet.MiniProjetBackend.Emploi.Examen.EmploiExamenDTO;
import Miniprojet.MiniProjetBackend.Ennumeration.Jour;
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
public class LigneEmploiExamenDTO {
    private String id_ligne_emp;
    @Enumerated
    private Jour jour;
    private LocalTime debut_seance;
    private LocalTime fin_seance;
    private EmploiExamenDTO emploiEx;
    private SalleDTO salle_ex;
    private EnseignantDTO enseignant_ex;
    private MatiereDTO matiere_ex;
    public static LigneEmploiExamenDTO fromEntity(LigneEmploiExamen ligneEmploiExamen){
        LigneEmploiExamenDTO ligneEmploiExamenDTO=new LigneEmploiExamenDTO();
        ligneEmploiExamenDTO.setId_ligne_emp(ligneEmploiExamen.getId_ligne_emp());
        ligneEmploiExamenDTO.setDebut_seance(ligneEmploiExamen.getDebut_seance());
        ligneEmploiExamenDTO.setFin_seance(ligneEmploiExamen.getFin_seance());
        ligneEmploiExamenDTO.setEmploiEx(EmploiExamenDTO.fromEntity(ligneEmploiExamen.getEmploiEx()));
        ligneEmploiExamenDTO.setSalle_ex(SalleDTO.fromEntity(ligneEmploiExamen.getSalle_ex()));
        ligneEmploiExamenDTO.setEnseignant_ex(EnseignantDTO.fromEntity(ligneEmploiExamen.getEnseignant_ex()));
        ligneEmploiExamenDTO.setMatiere_ex(MatiereDTO.fromEntity(ligneEmploiExamen.getMatiere_ex()));
        return ligneEmploiExamenDTO;
    }

    public LigneEmploiExamen toEntity(){
        LigneEmploiExamen ligneEmploiExamen=new LigneEmploiExamen();
        ligneEmploiExamen.setId_ligne_emp(this.getId_ligne_emp());
        ligneEmploiExamen.setDebut_seance(this.getDebut_seance());
        ligneEmploiExamen.setFin_seance(this.getFin_seance());
        ligneEmploiExamen.setEmploiEx(this.getEmploiEx().toEntity());
        ligneEmploiExamen.setSalle_ex(this.getSalle_ex().toEntity());
        ligneEmploiExamen.setEnseignant_ex(this.getEnseignant_ex().toEntity());
        ligneEmploiExamen.setMatiere_ex(this.getMatiere_ex().toEntity());
        return ligneEmploiExamen;
    }

    public static List<LigneEmploiExamenDTO> toDTOList(List<LigneEmploiExamen> ligneEmploiExamens) {
        return ligneEmploiExamens.stream().map(LigneEmploiExamenDTO::fromEntity).collect(Collectors.toList());
    }

    public static List<LigneEmploiExamen> toEntityList(List<LigneEmploiExamenDTO> dtos) {
        return dtos.stream().map(LigneEmploiExamenDTO::toEntity).collect(Collectors.toList());
    }
}
