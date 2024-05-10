package Miniprojet.MiniProjetBackend.Grade;

import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;
    private final EnseignantRepository enseignentrepository;

    @Autowired
    public GradeService(GradeRepository gradeRepository, EnseignantRepository enseignentrepository) {
        this.gradeRepository = gradeRepository;
        this.enseignentrepository = enseignentrepository;
    }

    public Grade ajouterGrade(Grade grade){
        return gradeRepository.save(grade);
    }

    public Grade modifierGrade(Grade grade){
        return gradeRepository.save(grade);
    }

    public void supprimerGrade(String id){
        gradeRepository.deleteById(id);
    }
    public Optional<Grade> getGrade(String id){
        return gradeRepository.findById(id);
    }

    public List<Grade> getAllGrades(){
        return gradeRepository.findAll();
    }

    public Grade ajouterEnseignentAuListe(String idGrade,String idEnseignent){
        Grade grade=gradeRepository.findById(idGrade).get();
        Enseignant enseignant=enseignentrepository.findById(idEnseignent).get();
        List<Enseignant> enseignants=grade.getListeEnseignants();
        enseignants.add(enseignant);
        grade.setListeEnseignants(enseignants);
        return gradeRepository.save(grade);
    }
}
