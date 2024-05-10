package Miniprojet.MiniProjetBackend.Specialite;


import Miniprojet.MiniProjetBackend.Departement.DepartementDTO;
import Miniprojet.MiniProjetBackend.groupe.GroupeResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class SpecialiteDTO {
    private String nom_specialite;
    private String description;
    private DepartementDTO departement;
    private List<GroupeResponseDto> listeGroupes;

    public static SpecialiteDTO fromEntity(Specialite specialite){
        return null;
    }

    public Specialite toEntity(){
        return null;
    }

    public static List<SpecialiteDTO> toDTOList(List<Specialite> specialites) {
        return specialites.stream().map(SpecialiteDTO::fromEntity).collect(Collectors.toList());
    }

    public static List<Specialite> toEntityList(List<SpecialiteDTO> dtos) {
        return dtos.stream().map(SpecialiteDTO::toEntity).collect(Collectors.toList());
    }
}
