package Miniprojet.MiniProjetBackend.Profile.Etudiant;


import java.util.List;
import java.util.Optional;
import Miniprojet.MiniProjetBackend.groupe.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,String> {
    Optional<Etudiant> findByEmail(String email);
    Optional<List<Etudiant>> findAllByGroupe(Groupe groupe);
}
