package Miniprojet.MiniProjetBackend.RapportDeStage;

import Miniprojet.MiniProjetBackend.Profile.Etudiant.Etudiant;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class RapportDeStageDTO {
    public String contenu;
    public Date date_soumission;
    public String status;
    private Etudiant proprietaire;
}
