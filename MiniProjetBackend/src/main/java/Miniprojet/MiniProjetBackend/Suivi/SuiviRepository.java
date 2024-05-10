package Miniprojet.MiniProjetBackend.Suivi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuiviRepository extends JpaRepository<Suivi,String > {
}
