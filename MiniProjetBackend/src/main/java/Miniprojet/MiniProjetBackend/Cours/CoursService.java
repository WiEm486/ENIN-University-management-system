package Miniprojet.MiniProjetBackend.Cours;

import Miniprojet.MiniProjetBackend.Matiere.Matiere;
import Miniprojet.MiniProjetBackend.Matiere.MatiereRepository;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.EnseignantDTO;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.EnseignantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursService {
    private final CoursRepository coursRepository;
    private final EnseignantRepository enseignentrepository;
    private final MatiereRepository matiereRepository;

    public CoursService(CoursRepository coursRepository, EnseignantRepository enseignentrepository,
                        MatiereRepository matiereRepository) {
        this.coursRepository = coursRepository;
        this.enseignentrepository = enseignentrepository;
        this.matiereRepository = matiereRepository;
    }

    public CoursDTO ajoutercours(CoursDTO coursdto){
        Cours cours=new Cours();
        cours.setId_cours(coursdto.getId_cours());
        cours.setContenu(coursdto.getContenu());
        cours.setDate_depot(coursdto.getDate_depot());
        Optional<Enseignant> enseignant  = enseignentrepository.findByNom(coursdto.getEnseignant());
        Optional<Matiere> matiere = matiereRepository.findByNom(coursdto.getMatiere());
        if (enseignant.isPresent() && matiere.isPresent()){
            cours.setEnseignant(enseignant.get());
            cours.setMatiere(matiere.get());
        }
        coursRepository.save(cours);
        return CoursDTO.fromEntity(cours);
    }
    public void supprimerCours(String id){
        coursRepository.deleteById(id);
    }

    public CoursDTO modifierCours(CoursDTO coursDTO){
        Cours cours = getCours(coursDTO.getId_cours()).get();
        cours.setContenu(coursDTO.getContenu());
        coursRepository.save(cours);
        return coursDTO;

    }

    public Optional<Cours> getCours(String id){
        return coursRepository.findById(id);
    }
    public List<Cours> getAllCours(){
        return coursRepository.findAll();
    }
    public Cours ajouterEnseignantAuCours(String id, String cin){
        Cours cours=coursRepository.findById(id).get();
        Enseignant enseignant=enseignentrepository.findById(cin).get();
        cours.setEnseignant(enseignant);
        return coursRepository.save(cours);
    }
    public Cours ajouterMatiereAuCours(String idC,String idM){
        Cours cours=coursRepository.findById(idC).get();
        Matiere matiere=matiereRepository.findById(idM).get();
        cours.setMatiere(matiere);
        return coursRepository.save(cours);
    }
    public List<Cours> getByMatiere(String nom_matiere){
        Optional<Matiere> matiere = matiereRepository.findByNom(nom_matiere);
        if (matiere.isPresent()){
            List<Cours> liste = coursRepository.findAllByMatiere(matiere.get());
            return liste;
        }
        return null;
    }
}
