package Miniprojet.MiniProjetBackend.Matiere;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere,String> {
    Optional<Matiere> findByNom(String matiere);
}
