package Miniprojet.MiniProjetBackend.Profile.Etudiant;

import Miniprojet.MiniProjetBackend.groupe.Groupe;
import lombok.Data;



@Data
//Object for Signing in
public class EtudiantDTORequest {
    private String num_inscription;
    private String CIN;
    private String email;
    private String nom;
    private String prenom;
    private String mot_de_passe;
    private Groupe groupe;

}
