package Miniprojet.MiniProjetBackend.Actualite;

import Miniprojet.MiniProjetBackend.Ennumeration.CibleActualite;
import Miniprojet.MiniProjetBackend.Ennumeration.TypeActualite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActualiteRepository extends JpaRepository<Actualite,String> {

    List<Actualite> findByCible(CibleActualite cible);

    List<Actualite> findByType(TypeActualite type);

}
