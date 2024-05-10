package Miniprojet.MiniProjetBackend.Profile.Etudiant;

import Miniprojet.MiniProjetBackend.groupe.Groupe;
import lombok.Data;

import java.util.Date;

@Data
public class EtudiantDtoUpdate {
    String num_inscription;
    String CIN;
    String email;
    String nom;
    String prenom;
    Date date_naissance;
    String photo;
    String mot_de_passe;
    Long num_tel;
    String addresse;
    Groupe groupe;

}
