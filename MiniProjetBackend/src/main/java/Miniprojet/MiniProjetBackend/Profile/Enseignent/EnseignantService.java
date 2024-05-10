package Miniprojet.MiniProjetBackend.Profile.Enseignent;

import Miniprojet.MiniProjetBackend.Departement.Departement;
import Miniprojet.MiniProjetBackend.Departement.DepartementRepository;
import Miniprojet.MiniProjetBackend.Ennumeration.Role;
import Miniprojet.MiniProjetBackend.Grade.Grade;
import Miniprojet.MiniProjetBackend.Grade.GradeRepository;
import Miniprojet.MiniProjetBackend.Matiere.Matiere;
import Miniprojet.MiniProjetBackend.Matiere.MatiereRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnseignantService {
    private final EnseignantRepository enseignentrepository;
    private final MatiereRepository  matiereRepository;

    private final GradeRepository gradeRepository;
    private final DepartementRepository departementRepository;
    public EnseignantService(EnseignantRepository enseignentrepository, MatiereRepository matiereRepository, GradeRepository gradeRepository,
                             DepartementRepository departementRepository) {
        this.enseignentrepository = enseignentrepository;
        this.matiereRepository = matiereRepository;
        this.gradeRepository = gradeRepository;
        this.departementRepository = departementRepository;
    }

    public Enseignant ajouterEnseignant(EnseignantDTO enseignantDTO){
        Enseignant enseignant = new Enseignant();
        enseignant.setNum_enseignant(enseignantDTO.getNum_enseignant());
        enseignant.setCIN(enseignantDTO.getCIN());
        enseignant.setNom(enseignantDTO.getNom());
        enseignant.setPrenom(enseignantDTO.getPrenom());
        enseignant.setPassword(enseignantDTO.getPassword());
        enseignant.setEmail(enseignantDTO.getEmail());
        enseignant.setPhoto(enseignantDTO.getPhoto());
        enseignant.setAddresse(enseignantDTO.getAddresse());
        enseignant.setNum_tel(enseignantDTO.getNum_tel());
        enseignant.setDate_embauche(enseignantDTO.getDate_embauche());
        enseignant.setRole(Role.ENSEIGNANT);
        Optional<Grade> grade = gradeRepository.findById(enseignantDTO.getGrade());
        if (grade.isPresent())
            enseignant.setGrade(grade.get());
        Optional<Departement> departement = departementRepository.findById(enseignantDTO.getDepartement());
        if (departement.isPresent())
            enseignant.setDepartement(departement.get());
        return enseignentrepository.save(enseignant);
    }

    public void supprimerEnseignant(String id){
        enseignentrepository.deleteById(id);
    }

    public Optional<Enseignant> getEnseignant(String id){
        return enseignentrepository.findById(id);
    }

    public List<Enseignant> getAllEnseignant(){
        return enseignentrepository.findAll();
    }

    public List<Enseignant> getByMatiere(String nomMatiere){
        Optional<Matiere> matiere = matiereRepository.findByNom(nomMatiere);
        if(matiere.isPresent()){
            return enseignentrepository.findByMatiere(matiere.get());
        }
        return null;
    }
}

