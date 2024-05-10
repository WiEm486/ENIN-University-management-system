package Miniprojet.MiniProjetBackend.Emploi.Examen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploiExamenRepository extends JpaRepository<EmploiExamen,String> {
}
