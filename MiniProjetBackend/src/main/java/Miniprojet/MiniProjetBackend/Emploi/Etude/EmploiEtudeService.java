package Miniprojet.MiniProjetBackend.Emploi.Etude;

import Miniprojet.MiniProjetBackend.LigneEmploi.Etude.LigneEmploiEtude;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmploiEtudeService {
    private final EmploiEtudesRepository emploiEtudesRepository;

    public EmploiEtudeService(EmploiEtudesRepository emploiEtudesRepository) {
        this.emploiEtudesRepository = emploiEtudesRepository;
    }

    public EmploiEtude ajouterEmploiEtude(EmploiEtude emploiEtude){
        return emploiEtudesRepository.save(emploiEtude);
    }

    public EmploiEtude modifierEmploiEtude(EmploiEtude emploiEtude){
        return emploiEtudesRepository.save(emploiEtude);
    }
    public void supprimerEmploiEtude(String id){
        emploiEtudesRepository.deleteById(id);
    }
    public Optional<EmploiEtude> getEmploiEtude(String id){
        return emploiEtudesRepository.findById(id);
    }

    public List<EmploiEtude> getAllEmploietude(){
        return emploiEtudesRepository.findAll();
    }
}
