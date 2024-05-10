package Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeConges;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeCongesRepository extends JpaRepository<DemandeConges,String> {

}
