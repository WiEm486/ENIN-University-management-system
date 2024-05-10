package Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeEtudiant;

import Miniprojet.MiniProjetBackend.Profile.Etudiant.Etudiant;
import Miniprojet.MiniProjetBackend.Profile.Etudiant.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeEtudiantService {
    private final DemandeEtudiantRepository demandeEtudiantRepository;
    private final EtudiantRepository etudiantRepository;

    @Autowired
    public DemandeEtudiantService(DemandeEtudiantRepository etudiantRepository, EtudiantRepository etudiantRepository1) {
        this.demandeEtudiantRepository = etudiantRepository;
        this.etudiantRepository = etudiantRepository1;
    }
    public DemandeEtudiant ajouterDemandeEtudiant(DemandeEtudiant demandeEtudiant) {
        return demandeEtudiantRepository.save(demandeEtudiant);
    }
    public DemandeEtudiant modifierDemandeEtudiant(DemandeEtudiant demandeEtudiant){
        return demandeEtudiantRepository.save(demandeEtudiant);
    }
    public void supprimerDemandeEtudiant(String id){
        demandeEtudiantRepository.deleteById(id);
    }
    public Optional<DemandeEtudiant> getDemandeEtudiant(String id){
        return demandeEtudiantRepository.findById(id);
    }
    public List<DemandeEtudiant> getAllDemandesEtudiant(){
        return demandeEtudiantRepository.findAll();
    }
    public DemandeEtudiant ajouterEtudiantAuDemande(String id_demande,String cin_etudiant){
        DemandeEtudiant demande=demandeEtudiantRepository.findById(id_demande).get();
        Etudiant etudiant=etudiantRepository.findById(cin_etudiant).get();
        demande.setProprietaireEtu(etudiant);
        return demandeEtudiantRepository.save(demande);
    }
}
