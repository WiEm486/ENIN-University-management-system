package Miniprojet.MiniProjetBackend.Profile.AdminEtudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;


@Repository
public interface AdminEtudiantRepository extends JpaRepository<AdminEtudiant,String> {

    Optional<AdminEtudiant> findByEmail(String email);
}
