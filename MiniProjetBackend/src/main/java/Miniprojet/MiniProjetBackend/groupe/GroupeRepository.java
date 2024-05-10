package Miniprojet.MiniProjetBackend.groupe;

import Miniprojet.MiniProjetBackend.Ennumeration.Niveau;
import Miniprojet.MiniProjetBackend.Profile.Etudiant.Etudiant;
import Miniprojet.MiniProjetBackend.Specialite.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupeRepository extends JpaRepository<Groupe, String> {
    List<Groupe> findAllBySpeciality(Specialite specialite);
    List<Groupe> findAllByNiveau(Niveau niveau);

    List<Groupe> findAllBySpecialityAndNiveau(Specialite specialite, Niveau niveau);

    Optional<Groupe> findByNom(String proprietaireR);
}
