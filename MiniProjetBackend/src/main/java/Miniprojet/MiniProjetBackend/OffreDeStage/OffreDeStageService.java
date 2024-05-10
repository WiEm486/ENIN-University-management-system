package Miniprojet.MiniProjetBackend.OffreDeStage;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffreDeStageService {
    private final OffreDeStageRepository offreDeStageRepository;

    public OffreDeStageService(OffreDeStageRepository offreDeStageRepository) {
        this.offreDeStageRepository = offreDeStageRepository;
    }

    public OffreDeStage ajouterOffreDeStage(OffreDeStage offreDeStage){
        return offreDeStageRepository.save(offreDeStage);
    }
    public OffreDeStage modifierOffreDeStage(OffreDeStage offreDeStage) {
        return offreDeStageRepository.save(offreDeStage);
    }
    public void supprimerOffreDeStage(String id){
        offreDeStageRepository.deleteById(id);
    }
    public OffreDeStage getOffreDeStage(String id){
        return offreDeStageRepository.findById(id).get();
    }
    public List<OffreDeStage> getAllOffreDeStages(){
        return offreDeStageRepository.findAll();
    }
}
