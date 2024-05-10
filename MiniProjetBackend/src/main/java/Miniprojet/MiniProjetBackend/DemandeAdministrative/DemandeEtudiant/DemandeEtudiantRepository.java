package Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeEtudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeEtudiantRepository extends JpaRepository<DemandeEtudiant,String > {
}
