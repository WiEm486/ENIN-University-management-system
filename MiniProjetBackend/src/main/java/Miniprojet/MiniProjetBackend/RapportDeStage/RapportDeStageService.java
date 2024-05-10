package Miniprojet.MiniProjetBackend.RapportDeStage;

import Miniprojet.MiniProjetBackend.Profile.Etudiant.Etudiant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RapportDeStageService {
    private final RapportdeStageRepository rapportdeStageRepository;

    public RapportDeStageService(RapportdeStageRepository rapportdeStageRepository) {
        this.rapportdeStageRepository = rapportdeStageRepository;
    }
    public RapportDeStage ajouterRapportDeStage(RapportDeStage rapportDeStage){
        return rapportdeStageRepository.save(rapportDeStage);
    }
    public RapportDeStage modifierRapportDeStage(RapportDeStage rapportDeStage){
        return rapportdeStageRepository.save(rapportDeStage);
    }
    public void supprimerRapportDeStage(String id){
        rapportdeStageRepository.deleteById(id);
    }
    public RapportDeStage getRapportDeStage(String id){
        return rapportdeStageRepository.findById(id).get();
    }
    public List<RapportDeStage> getAllRapportDeStages(){
        return rapportdeStageRepository.findAll();
    }
    public void ajouterProprietaire(String idRapport,String idEtudiant){

    }
    public List<RapportDeStage> getRapportDeStagesByProprietaire(Etudiant e){
        return rapportdeStageRepository.findByProprietaire(e);
    }
}
