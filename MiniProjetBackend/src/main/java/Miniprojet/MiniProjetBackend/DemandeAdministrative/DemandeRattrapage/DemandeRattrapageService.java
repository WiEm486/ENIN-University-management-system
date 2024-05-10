package Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeRattrapage;

import Miniprojet.MiniProjetBackend.Ennumeration.Jour;
import Miniprojet.MiniProjetBackend.Ennumeration.StatusDemande;
import Miniprojet.MiniProjetBackend.Matiere.Matiere;
import Miniprojet.MiniProjetBackend.Matiere.MatiereRepository;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.EnseignantRepository;
import Miniprojet.MiniProjetBackend.groupe.Groupe;
import Miniprojet.MiniProjetBackend.groupe.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeRattrapageService {
    private final DemandeRattrapageRepository demandeRattrapageRepository;
    private final EnseignantRepository enseignentrepository;
    private final GroupeRepository groupeRepository;
    private final MatiereRepository matiererepository;
    @Autowired
    public DemandeRattrapageService(
            DemandeRattrapageRepository demandeRattrapageRepository,
            EnseignantRepository enseignantRepository, GroupeRepository groupeRepository,
            MatiereRepository matiererepository) {
        this.demandeRattrapageRepository = demandeRattrapageRepository;
        this.enseignentrepository = enseignantRepository;
        this.groupeRepository = groupeRepository;
        this.matiererepository = matiererepository;
    }

    public DemandeRattrapage ajouterDemandeRattrapage(DemandeRattrapageDTO rattrapageDTO) {
        Optional<Enseignant> enseignant = enseignentrepository.findByNom(rattrapageDTO.getProprietaireR());
        Optional<Groupe> groupe = groupeRepository.findByNom(rattrapageDTO.getNom_groupe());
        Optional<Matiere> matiere = matiererepository.findByNom(rattrapageDTO.getMatiere());
        if (enseignant.isPresent() && groupe.isPresent() && matiere.isPresent())
        {
            DemandeRattrapage demandeRattrapage = new DemandeRattrapage();
            demandeRattrapage.setProprietaireR(enseignant.get());
            demandeRattrapage.setStatus(StatusDemande.fromString(rattrapageDTO.getStatus()));
            demandeRattrapage.setCommentaire(rattrapageDTO.getCommentaire());
            demandeRattrapage.setJour(Jour.fromString(rattrapageDTO.getJour()));
            demandeRattrapage.setDebut(rattrapageDTO.getDebut());
            demandeRattrapage.setFin(rattrapageDTO.getFin());
            demandeRattrapage.setGroupe(groupe.get());
            demandeRattrapage.setMatiere(matiere.get());

            return demandeRattrapageRepository.save(demandeRattrapage);
        }
        return null;
    }
    public DemandeRattrapage modifierDemandeRattrapage(DemandeRattrapage demandeRattrapage){

        return demandeRattrapageRepository.save(demandeRattrapage);
    }
    public void supprimerDemandeRattrapage(String id){
        demandeRattrapageRepository.deleteById(id);
    }
    public Optional<DemandeRattrapage> getDemandeRattrapage(String id){
        return demandeRattrapageRepository.findById(id);
    }
    public List<DemandeRattrapage> getAllDemandesRattrapage(){
        return demandeRattrapageRepository.findAll();
    }
    public DemandeRattrapage ajouterEnseignantAuDemande(String id_demande, String cin_enseignant){
        DemandeRattrapage demande=demandeRattrapageRepository.findById(id_demande).get();
        Enseignant enseignant=enseignentrepository.findById(cin_enseignant).get();
        demande.setProprietaireR(enseignant);
        return demandeRattrapageRepository.save(demande);
    }

    public DemandeRattrapage updateStatus(DemandeRattrapage demande, StatusDemande statusDemande) {
        demande.setStatus(statusDemande);
        return demandeRattrapageRepository.save(demande);
    }
}
