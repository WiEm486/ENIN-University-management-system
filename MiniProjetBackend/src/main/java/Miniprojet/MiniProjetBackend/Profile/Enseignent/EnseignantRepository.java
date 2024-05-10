package Miniprojet.MiniProjetBackend.Profile.Enseignent;


import Miniprojet.MiniProjetBackend.Matiere.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnseignantRepository  extends JpaRepository<Enseignant, String> {
    Optional<Enseignant> findByEmail(String email);

    Optional<Enseignant> findByNom(String proprietaireR);

    List<Enseignant> findByMatiere(Matiere matiere);
}
