package Miniprojet.MiniProjetBackend.Profile.Enseignent.ChefDepartement;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.Optional;

@Repository
public interface ChefDepartementRepository extends JpaRepository<ChefDepartement,String> {
    Optional<ChefDepartement> findByEmail(String username);
}
