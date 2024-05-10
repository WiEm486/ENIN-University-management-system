package Miniprojet.MiniProjetBackend.LigneEmploi.Etude;

import Miniprojet.MiniProjetBackend.Emploi.Etude.EmploiEtude;
import Miniprojet.MiniProjetBackend.Emploi.Etude.EmploiEtudesRepository;
import Miniprojet.MiniProjetBackend.Matiere.Matiere;
import Miniprojet.MiniProjetBackend.Matiere.MatiereRepository;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.EnseignantRepository;
import Miniprojet.MiniProjetBackend.Salle.Salle;
import Miniprojet.MiniProjetBackend.Salle.SalleRepository;
import Miniprojet.MiniProjetBackend.groupe.GroupeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneEmlpoiEtudeService {
    private final LigneEmploiEtudeRepository ligneEmploiEtudeRepository;
    private final GroupeRepository groupeRepository;
    private final EmploiEtudesRepository emploiEtudesRepository;
    private final SalleRepository salleRepository;
    private final MatiereRepository matiereRepository;
    private final EnseignantRepository enseignantRepository;

    public LigneEmlpoiEtudeService(LigneEmploiEtudeRepository ligneEmploiEtudeRepository,
                                   GroupeRepository groupeRepository,
                                   EmploiEtudesRepository emploiEtudesRepository, SalleRepository salleRepository, MatiereRepository matiereRepository, EnseignantRepository enseignantRepository) {
        this.ligneEmploiEtudeRepository = ligneEmploiEtudeRepository;
        this.groupeRepository = groupeRepository;
        this.emploiEtudesRepository = emploiEtudesRepository;
        this.salleRepository = salleRepository;
        this.matiereRepository = matiereRepository;
        this.enseignantRepository = enseignantRepository;
    }

    public LigneEmploiEtude ajouterLigneEmploiEtude(String id, LigneEmploiEtudeDTO ligneEmploiEtudeDTO){
        LigneEmploiEtude ligne = new LigneEmploiEtude();
        Optional<EmploiEtude> emploi = emploiEtudesRepository.findById(id);
        Optional<Salle> salle = salleRepository.findByNoms(ligneEmploiEtudeDTO.getSalle_et());
        Optional<Matiere> matiere = matiereRepository.findByNom(ligneEmploiEtudeDTO.getMatiere_et());
        Optional<Enseignant> enseignant = enseignantRepository.findByNom(ligneEmploiEtudeDTO.getEnseignant_et());
        if (emploi.isPresent() && salle.isPresent() && matiere.isPresent() && enseignant.isPresent()){
            ligne.setEmploiEt(emploi.get());
            ligne.setType(ligneEmploiEtudeDTO.getType());
            ligne.setRegime(ligneEmploiEtudeDTO.getRegime());
            ligne.setJour(ligneEmploiEtudeDTO.getJour());
            ligne.setDebut_seance(ligneEmploiEtudeDTO.getDebut_seance());
            ligne.setFin_seance(ligneEmploiEtudeDTO.getFin_seance());
            ligne.setSalle_et(salle.get());
            ligne.setMatiere_et(matiere.get());
            ligne.setEnseignant_et(enseignant.get());
        }
        return ligneEmploiEtudeRepository.save(ligne);
    }

    public LigneEmploiEtude modifierLigneEmploiEtude(LigneEmploiEtude ligneEmploiEtude){
        return ligneEmploiEtudeRepository.save(ligneEmploiEtude);
    }

    public void supprimerLigneEmlpoiEtude(String id){
        ligneEmploiEtudeRepository.deleteById(id);
    }
    public Optional<LigneEmploiEtude> getLigneEmploiEtude(String id){
        return ligneEmploiEtudeRepository.findById(id);
    }

    public List<LigneEmploiEtude> getAllLigneEmploiEtude(){
        return ligneEmploiEtudeRepository.findAll();
    }

    public List<LigneEmploiEtude> getLigneEmlpoiEtudeByEmploi(String id){
        EmploiEtude emploiEtude=emploiEtudesRepository.findById(id).get();
        List<LigneEmploiEtude> ligneEmploiEtudes=ligneEmploiEtudeRepository.findByEmploiEt(emploiEtude);
        return ligneEmploiEtudes;
    }
}
