package Miniprojet.MiniProjetBackend.RapportDeStage;

import Miniprojet.MiniProjetBackend.Profile.Etudiant.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RapportdeStageRepository extends JpaRepository<RapportDeStage,String> {
    List<RapportDeStage> findByProprietaire(Etudiant e);
}
