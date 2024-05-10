package Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeRattrapage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeRattrapageRepository extends JpaRepository<DemandeRattrapage,String > {
}
