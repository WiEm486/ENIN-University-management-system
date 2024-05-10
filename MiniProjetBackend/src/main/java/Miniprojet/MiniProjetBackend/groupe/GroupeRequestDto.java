package Miniprojet.MiniProjetBackend.groupe;

import Miniprojet.MiniProjetBackend.Ennumeration.Niveau;
import Miniprojet.MiniProjetBackend.Specialite.Specialite;
import lombok.Data;

@Data
public class GroupeRequestDto {
    public String id_groupe;
    public String nom_groupe;
    public Integer nb_etudiants;
    public Specialite speciality;
    public Niveau niveau;
}
