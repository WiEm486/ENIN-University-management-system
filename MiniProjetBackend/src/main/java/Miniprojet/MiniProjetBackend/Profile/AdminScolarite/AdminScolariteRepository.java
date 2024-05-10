package Miniprojet.MiniProjetBackend.Profile.AdminScolarite;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminScolariteRepository  extends JpaRepository<AdminScolarite,String> {
    Optional<AdminScolarite> findByEmail(String email);
}
