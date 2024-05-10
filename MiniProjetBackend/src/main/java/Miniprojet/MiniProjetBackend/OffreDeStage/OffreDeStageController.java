package Miniprojet.MiniProjetBackend.OffreDeStage;

import Miniprojet.MiniProjetBackend.Grade.Grade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offredestage")
public class OffreDeStageController {
    private final OffreDeStageService offreDeStageService;

    public OffreDeStageController(OffreDeStageService offreDeStageService) {
        this.offreDeStageService = offreDeStageService;
    }
    @PostMapping("/ajouter")
    public ResponseEntity<OffreDeStage> ajouterOffreDeStage(OffreDeStage offreDeStage){
        OffreDeStage offreDeStage1=offreDeStageService.ajouterOffreDeStage(offreDeStage);
        return new ResponseEntity<>(offreDeStage1, HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<OffreDeStage> modifierOffreDeStage(@PathVariable("id") String id, OffreDeStage offreDeStage){
        OffreDeStage offreDeStage1=offreDeStageService.getOffreDeStage(id);
        offreDeStage1.setContact(offreDeStage.getContact());
        offreDeStage1.setDate_deb(offreDeStage.getDate_deb());
        offreDeStage1.setDate_fin(offreDeStage.getDate_fin());
        offreDeStage1.setDescription(offreDeStage.getDescription());
        offreDeStage1.setPost(offreDeStage.getPost());
        offreDeStage1.setEntrepris(offreDeStage.getEntrepris());
        offreDeStageService.modifierOffreDeStage(offreDeStage1);
        return new ResponseEntity<>(offreDeStage1,HttpStatus.OK);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimerOffreDeStage(@PathVariable("id") String id){
        offreDeStageService.supprimerOffreDeStage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OffreDeStage> getOffreDeStage(@PathVariable("id") String id){
        OffreDeStage offreDeStage=offreDeStageService.getOffreDeStage(id);
        return new ResponseEntity<>(offreDeStage,HttpStatus.OK);
    }
    @GetMapping("/tout")
    public ResponseEntity<List<OffreDeStage>> getAllOffreDeStages(){
        List<OffreDeStage> offreDeStages=offreDeStageService.getAllOffreDeStages();
        return new ResponseEntity<>(offreDeStages,HttpStatus.OK);
    }
}
