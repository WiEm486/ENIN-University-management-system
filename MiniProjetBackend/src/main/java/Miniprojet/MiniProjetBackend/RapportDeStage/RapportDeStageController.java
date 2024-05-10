package Miniprojet.MiniProjetBackend.RapportDeStage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rapportdestage")
public class RapportDeStageController {
    private final RapportDeStageService rapportDeStageService;

    public RapportDeStageController(RapportDeStageService rapportDeStageService) {
        this.rapportDeStageService = rapportDeStageService;
    }
    @PostMapping("/ajouter")
    public ResponseEntity<RapportDeStage> ajouterRapporteDeStage(RapportDeStage rapportDeStage){
        RapportDeStage rapportDeStage1=rapportDeStageService.ajouterRapportDeStage(rapportDeStage);
        return new ResponseEntity<>(rapportDeStage1, HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<RapportDeStage> modifierRapportDeStage(@PathVariable("id") String id, RapportDeStage rapportDeStage){
        RapportDeStage rapportDeStage1=rapportDeStageService.getRapportDeStage(id);
        rapportDeStage1.setProprietaire(rapportDeStage.getProprietaire());
        rapportDeStage1.setDate_soumission(rapportDeStage.getDate_soumission());
        rapportDeStage1.setContenu(rapportDeStage.getContenu());
        rapportDeStage1.setStatus(rapportDeStage.getStatus());
        rapportDeStageService.modifierRapportDeStage(rapportDeStage1);
        return new ResponseEntity<>(rapportDeStage1,HttpStatus.OK);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimerRapportDeStage(@PathVariable("id") String id){
        rapportDeStageService.supprimerRapportDeStage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RapportDeStage> getRapportDeStage(@PathVariable("id") String id){
        RapportDeStage rapportDeStage=rapportDeStageService.getRapportDeStage(id);
        return new ResponseEntity<>(rapportDeStage,HttpStatus.OK);
    }
    @GetMapping("/tout")
    public ResponseEntity<List<RapportDeStage>> getAllRapportDeStages(){
        List<RapportDeStage> rapportDeStages=rapportDeStageService.getAllRapportDeStages();
        return new ResponseEntity<>(rapportDeStages,HttpStatus.OK);
    }
}
