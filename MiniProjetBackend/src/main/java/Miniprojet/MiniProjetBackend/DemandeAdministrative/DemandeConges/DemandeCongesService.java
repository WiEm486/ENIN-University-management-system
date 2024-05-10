package Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeConges;

import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeCongesService {
    private final DemandeCongesRepository demandeCongesRepository;
    private final EnseignantRepository enseignentrepository;

    @Autowired
    public DemandeCongesService(DemandeCongesRepository demandeCongesRepository, EnseignantRepository enseignentrepository) {
        this.demandeCongesRepository = demandeCongesRepository;
        this.enseignentrepository = enseignentrepository;
    }

    public DemandeConges ajouterDemandeConges(DemandeConges demandeConges) {
        return demandeCongesRepository.save(demandeConges);
    }
    public DemandeConges modifierDemandeConges(DemandeConges demandeConges){
        return demandeCongesRepository.save(demandeConges);
    }
    public void supprimerDemandeConges(String id){
        demandeCongesRepository.deleteById(id);
    }
    public Optional<DemandeConges> getDemandeConges(String id){
        return demandeCongesRepository.findById(id);
    }
    public List<DemandeConges> getAllDemandesConges(){
        return demandeCongesRepository.findAll();
    }
    public DemandeConges ajouterEnseignantAuDemande(String id_demande,String cin_enseignant){
        DemandeConges demande=demandeCongesRepository.findById(id_demande).get();
        Enseignant enseignant=enseignentrepository.findById(cin_enseignant).get();
        demande.setProprietaireCong(enseignant);
        return demandeCongesRepository.save(demande);
    }
}
