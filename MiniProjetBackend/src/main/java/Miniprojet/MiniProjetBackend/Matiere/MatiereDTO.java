package Miniprojet.MiniProjetBackend.Matiere;


import Miniprojet.MiniProjetBackend.Cours.CoursDTO;
import Miniprojet.MiniProjetBackend.LigneEmploi.Etude.LigneEmploiEtudeDTO;
import Miniprojet.MiniProjetBackend.LigneEmploi.Examen.LigneEmploiExamenDTO;
import Miniprojet.MiniProjetBackend.LigneEmploi.Rattrapage.LigneEmploiRattrapageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class MatiereDTO {
    private String id_matiere;
    private String nom;
   // private List<EnseignantDTO> listeEnseignants;
    public List<CoursDTO> Cours_Deposes;
    private List<LigneEmploiEtudeDTO> lignes_emploi_et;
    private List<LigneEmploiRattrapageDTO> lignes_emploi_R;
    private List<LigneEmploiExamenDTO> lignes_emploi_ex;

    public static MatiereDTO fromEntity(Matiere matiere){
        MatiereDTO matiereDTO=new MatiereDTO();
        matiereDTO.setId_matiere(matiere.getId_matiere());
        matiereDTO.setNom(matiere.getNom());
        //matiereDTO.setListeEnseignants(EnseignantDTO.toDTOList(matiere.getListeEnseignants()));
        matiereDTO.setCours_Deposes(CoursDTO.toDTOList(matiere.getCours_Deposes()));
        matiereDTO.setLignes_emploi_et(LigneEmploiEtudeDTO.toDTOList(matiere.getLignes_emploi_et()));
        matiereDTO.setLignes_emploi_R(LigneEmploiRattrapageDTO.toDTOList(matiere.getLignes_emploi_R()));
        matiereDTO.setLignes_emploi_ex(LigneEmploiExamenDTO.toDTOList(matiere.getLignes_emploi_ex()));
        return matiereDTO;
    }

    public Matiere toEntity(){
        Matiere matiere=new Matiere();
        matiere.setId_matiere(this.getId_matiere());
        matiere.setNom(this.getNom());
        //matiere.setListeEnseignants(EnseignantDTO.toEntityList(this.listeEnseignants));
        //matiere.setCours_Deposes(CoursDTO.toEntityList(this.getCours_Deposes()));
        //matiere.setLignes_emploi_et(LigneEmploiEtudeDTO.toEntityList(this.lignes_emploi_et));
        //matiere.setLignes_emploi_R(LigneEmploiRattrapageDTO.toEntityList(this.getLignes_emploi_R()));
        //matiere.setLignes_emploi_ex(LigneEmploiExamenDTO.toEntityList(this.getLignes_emploi_ex()));
        return matiere;
    }

    public static List<MatiereDTO> toDTOList(List<Matiere> matieres) {
        return matieres.stream().map(MatiereDTO::fromEntity).collect(Collectors.toList());
    }

    public static List<Matiere> toEntityList(List<MatiereDTO> dtos) {
        return dtos.stream().map(MatiereDTO::toEntity).collect(Collectors.toList());
    }
}
