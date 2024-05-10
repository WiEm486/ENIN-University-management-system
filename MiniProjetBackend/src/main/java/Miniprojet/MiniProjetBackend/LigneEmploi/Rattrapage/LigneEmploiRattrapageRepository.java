package Miniprojet.MiniProjetBackend.LigneEmploi.Rattrapage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneEmploiRattrapageRepository extends JpaRepository<LigneEmploiRattrapage,String> {
}
