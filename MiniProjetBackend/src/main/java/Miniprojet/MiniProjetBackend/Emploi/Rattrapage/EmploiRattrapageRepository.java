package Miniprojet.MiniProjetBackend.Emploi.Rattrapage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploiRattrapageRepository extends JpaRepository<EmploiRattrapage,String> {
}
