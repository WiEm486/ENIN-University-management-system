package Miniprojet.MiniProjetBackend.LigneEmploi.Etude;

import Miniprojet.MiniProjetBackend.Emploi.Etude.EmploiEtude;
import Miniprojet.MiniProjetBackend.groupe.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneEmploiEtudeRepository extends JpaRepository<LigneEmploiEtude,String> {

    List<LigneEmploiEtude> findByEmploiEt(EmploiEtude emploiEtude);
}
