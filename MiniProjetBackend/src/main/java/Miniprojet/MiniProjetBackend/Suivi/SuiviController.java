package Miniprojet.MiniProjetBackend.Suivi;

import Miniprojet.MiniProjetBackend.RapportDeStage.RapportDeStage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suivi")
@CrossOrigin
public class SuiviController {
    private final SuiviService suiviService;

    public SuiviController(SuiviService suiviService) {
        this.suiviService = suiviService;
    }
    @PostMapping("/ajouter")
    public ResponseEntity<Suivi> ajouterRapporteDeStage(Suivi suivi){
        Suivi suivi1=suiviService.ajouterSuivi(suivi);
        return new ResponseEntity<>(suivi1, HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Suivi> modifierSuivi(@PathVariable("id") String id, Suivi suivi){
        Suivi suivi1=suiviService.getSuivi(id);
        suivi1.setNb_absence(suivi.getNb_absence());
        suivi1.setNote_ds(suivi.getNote_ds());
        suivi1.setNote_tp(suivi.getNote_tp());
        suivi1.setNote_examen(suivi.getNote_examen());
        suiviService.modifierSuivi(suivi1);
        return new ResponseEntity<>(suivi1,HttpStatus.OK);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimerSuivi(@PathVariable("id") String id){
        suiviService.supprimerSuivi(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suivi> getSuivi(@PathVariable("id") String id){
        Suivi suivi=suiviService.getSuivi(id);
        return new ResponseEntity<>(suivi,HttpStatus.OK);
    }
    @GetMapping("/tout")
    public ResponseEntity<List<Suivi>> getAllSuivis(){
        List<Suivi> suivis=suiviService.getAllSuivis();
        return new ResponseEntity<>(suivis,HttpStatus.OK);
    }
}
