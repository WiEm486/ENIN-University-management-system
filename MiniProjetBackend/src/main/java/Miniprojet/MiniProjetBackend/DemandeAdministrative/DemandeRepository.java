package Miniprojet.MiniProjetBackend.DemandeAdministrative;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DemandeRepository<T extends DemandeAdministrative> extends JpaRepository<T, String>  {
}
