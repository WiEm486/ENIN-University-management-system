package Miniprojet.MiniProjetBackend.Profile.Enseignent;

import Miniprojet.MiniProjetBackend.Actualite.ActualiteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/enseignant")

public class EnseignantController {
    private final EnseignantService enseignantService;

    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Enseignant> ajouterEnseignant(@RequestBody EnseignantDTO enseignantDTO){
        Enseignant enseignant=enseignantService.ajouterEnseignant(enseignantDTO);
        return new ResponseEntity<>(enseignant, HttpStatus.CREATED);
    }
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimerenseignant(@PathVariable("id") String id){
        enseignantService.supprimerEnseignant(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EnseignantDTO> getEnseignant(@PathVariable("id") String id){
        Optional<Enseignant> enseignant=enseignantService.getEnseignant(id);
        return enseignant.map(enseignant1 -> new ResponseEntity<>(EnseignantDTO.fromEntity(enseignant1), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/tous")
    public ResponseEntity<List<EnseignantDTO>> getAllEnseignant(){
        List<Enseignant> enseignants=enseignantService.getAllEnseignant();
        return new ResponseEntity<>(EnseignantDTO.toDTOList(enseignants),HttpStatus.OK);
    }

    @GetMapping("/tous/{idMatiere}")
    public ResponseEntity<List<EnseignantDTO>> getAllByMatiere(@PathVariable String idMatiere){
        List<Enseignant> enseignants=enseignantService.getByMatiere(idMatiere);
        return new ResponseEntity<>(EnseignantDTO.toDTOList(enseignants),HttpStatus.OK);
    }

}
