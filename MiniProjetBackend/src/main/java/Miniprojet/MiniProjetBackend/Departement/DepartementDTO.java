package Miniprojet.MiniProjetBackend.Departement;

import Miniprojet.MiniProjetBackend.Profile.Enseignent.ChefDepartement.ChefDepartement;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import Miniprojet.MiniProjetBackend.Specialite.Specialite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class DepartementDTO {
    private String departement;
    private String description;
    private List<Enseignant> listeEnseignants;
    private ChefDepartement chef;
    private List<Specialite> listeSpecialites;

    public static DepartementDTO fromEntity(Departement departement){
        DepartementDTO departementDTO=new DepartementDTO();
        departementDTO.setDepartement(departement.getDepartement());
        departementDTO.setDescription(departement.getDescription());
        departementDTO.setChef(departement.getChef());
        departementDTO.setListeEnseignants(departement.getListeEnseignants());
        departementDTO.setListeSpecialites(departement.getListeSpecialites());
        return departementDTO;
    }

    public Departement toEntity(){
        Departement departement=new Departement();
        departement.setDepartement(this.getDepartement());
        departement.setDescription(this.getDescription());
        departement.setChef(this.getChef());
        departement.setListeEnseignants(this.getListeEnseignants());
        departement.setListeSpecialites(this.getListeSpecialites());
        return null;
    }
    public static List<DepartementDTO> toDTOList(List<Departement> departements) {
        return departements.stream().map(DepartementDTO::fromEntity).collect(Collectors.toList());
    }
    public static List<Departement> toEntityList(List<DepartementDTO> dtos) {
        return dtos.stream().map(DepartementDTO::toEntity).collect(Collectors.toList());
    }
}
