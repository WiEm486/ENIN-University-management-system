package Miniprojet.MiniProjetBackend.Salle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalleRepository extends JpaRepository<Salle,String> {
    public Optional<Salle> findByNoms(String nom);
}
