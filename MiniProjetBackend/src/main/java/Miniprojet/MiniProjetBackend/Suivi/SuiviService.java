package Miniprojet.MiniProjetBackend.Suivi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuiviService {
    private final SuiviRepository suiviRepository;

    public SuiviService(SuiviRepository suiviRepository) {
        this.suiviRepository = suiviRepository;
    }

    public Suivi ajouterSuivi(Suivi suivi){
        return suiviRepository.save(suivi);
    }
    public Suivi modifierSuivi(Suivi suivi){
        return suiviRepository.save(suivi);
    }
    public void supprimerSuivi(String id){
        suiviRepository.deleteById(id);
    }
    public Suivi getSuivi(String id){
        return suiviRepository.findById(id).get();
    }
    public List<Suivi> getAllSuivis(){
        return suiviRepository.findAll();
    }
}
