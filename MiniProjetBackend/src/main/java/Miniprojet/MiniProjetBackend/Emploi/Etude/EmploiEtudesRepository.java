package Miniprojet.MiniProjetBackend.Emploi.Etude;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploiEtudesRepository extends JpaRepository<EmploiEtude,String> {
}
