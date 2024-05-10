package Miniprojet.MiniProjetBackend.Cours;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cours")
@CrossOrigin
public class CoursController {
    private final CoursService coursService;

    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }
    @PostMapping("/ajouter")
    public ResponseEntity<CoursDTO> ajouterCours(@RequestBody CoursDTO coursDTO){
        CoursDTO new_cours = coursService.ajoutercours(coursDTO);
        return new ResponseEntity<>(new_cours, HttpStatus.CREATED);
    }
    @PutMapping("/modifier/{id}")
    public  ResponseEntity<?> modifierCours(@PathVariable String id,@RequestBody CoursDTO coursDTO){
        if (id.equals(coursDTO.getId_cours())){
            return new ResponseEntity<>(
                    coursService.modifierCours(coursDTO),
                    HttpStatus.OK);

        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimerCours(@PathVariable("id") String id){
        coursService.supprimerCours(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoursDTO> getBlock(@PathVariable("id") String id){
        Optional<Cours> cours=coursService.getCours(id);
        return cours.map(cours1 -> new ResponseEntity<>(CoursDTO.fromEntity(cours1), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/tout")
    public ResponseEntity<List<CoursDTO>> getAllCours(){
        List<Cours> cours = coursService.getAllCours();
        return new ResponseEntity<>(CoursDTO.toDTOList(cours),HttpStatus.OK);
    }

    @GetMapping("/all/{nom_matiere}")
    public ResponseEntity<List<CoursDTO>> getByMatiere(@PathVariable String nom_matiere){
        return new ResponseEntity<>(
                CoursDTO.toDTOList(coursService.getByMatiere(nom_matiere)),
                HttpStatus.OK);
    }



    @PostMapping("/{idC}/matiere/{idM}")
    public ResponseEntity<Cours> ajouterMatiereAuCours(@PathVariable String idC,@PathVariable String idM){
        Cours cours=coursService.ajouterMatiereAuCours(idC,idM);
        return new ResponseEntity<>(cours,HttpStatus.OK);
    }
    @PostMapping("/{idC}/enseignant/{cin}")
    public ResponseEntity<Cours> ajouterEnseignantAuCours(@PathVariable String idC,@PathVariable String cin){
        Cours cours=coursService.ajouterEnseignantAuCours(idC,cin);
        return new ResponseEntity<>(cours,HttpStatus.OK);
    }
}
