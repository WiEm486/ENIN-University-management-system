package Miniprojet.MiniProjetBackend.Grade;

import Miniprojet.MiniProjetBackend.Actualite.ActualiteDTO;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.EnseignantDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grade")
@CrossOrigin
public class gradeController {
    private final GradeService gradeService;

    public gradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }
    @PostMapping("/ajouter")
    public ResponseEntity<Grade> ajouterGrade(@RequestBody GradeDTO gradeDTO){
        Grade grade=gradeService.ajouterGrade(gradeDTO.toEntity());
        return new ResponseEntity<>(grade, HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Grade> modifierGrade(@PathVariable("id") String id, GradeDTO gradeDTO){
        Grade grade=gradeService.getGrade(id).get();
        grade.setCharge_horaire(gradeDTO.getCharge_horaire());
        grade.setDescription(gradeDTO.getDescription());
        grade.setListeEnseignants(EnseignantDTO.toEntityList(gradeDTO.getListeEnseignants()));
        gradeService.modifierGrade(grade);
        return new ResponseEntity<>(grade,HttpStatus.OK);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimerGrade(@PathVariable("id") String id){
        gradeService.supprimerGrade(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeDTO> getGrade(@PathVariable("id") String id){
        Optional<Grade> grade=gradeService.getGrade(id);
        return grade.map(grade1 -> new ResponseEntity<>(GradeDTO.fromEntity(grade1), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/tout")
    public ResponseEntity<List<GradeDTO>> getAllGrades(){
        List<Grade> grades=gradeService.getAllGrades();
        return new ResponseEntity<>(GradeDTO.toDTOList(grades),HttpStatus.OK);
    }
    @PostMapping("/ajouterEnseignant/{idG}/{cin}")
    public ResponseEntity<Grade> ajouterEnseignantAuGrade(@PathVariable("idG")String idG,@PathVariable("cin") String cin){
        Grade grade=gradeService.ajouterEnseignentAuListe(idG,cin);
        return new ResponseEntity<>(grade,HttpStatus.OK);
    }
}
