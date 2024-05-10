package Miniprojet.MiniProjetBackend.LigneEmploi.Examen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneEmploiExamenRepository extends JpaRepository<LigneEmploiExamen,String > {
}
