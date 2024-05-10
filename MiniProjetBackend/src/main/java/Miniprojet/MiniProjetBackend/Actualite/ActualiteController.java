package Miniprojet.MiniProjetBackend.Actualite;

import Miniprojet.MiniProjetBackend.Ennumeration.CibleActualite;
import Miniprojet.MiniProjetBackend.Ennumeration.StatusActualite;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/actualite")
@CrossOrigin
public class ActualiteController {
    private final ActualiteService actualiteService;

    public ActualiteController(ActualiteService actualiteService) {

        this.actualiteService = actualiteService;
    }
    @PostMapping("/ajouter")
    public ResponseEntity<ActualiteDTO> ajouterActualite(@RequestBody ActualiteDTO actualiteDTO){
        Actualite actualite=actualiteService.ajouterActuelite(actualiteDTO);
        return new ResponseEntity<>(ActualiteDTO.fromEntity(actualite), HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<ActualiteDTO> modifierActualite(@PathVariable("id") String id,
                                                       @RequestBody ActualiteDTO actualiteDTO){
        Actualite actualite = actualiteService.modifierActualite(id, actualiteDTO);
        if (actualite != null){
            return new ResponseEntity<>(ActualiteDTO.fromEntity(actualite),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/modifier/{id}/status")
    public ResponseEntity<ActualiteDTO> updateStatus(@PathVariable("id") String id, @RequestBody String status){
        Optional<Actualite> act = actualiteService.getActualite(id);
        if (act.isPresent()){
            Actualite actualite=actualiteService.getActualite(id).get();
            actualiteService.updateStatus(actualite, StatusActualite.valueOf(status));
            return new ResponseEntity<>(ActualiteDTO.fromEntity(actualite), HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimerActualite(@PathVariable("id") String id){
        actualiteService.supprimerActualite(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActualiteDTO> getActualite(@PathVariable("id") String id){
        Optional<Actualite> actualite=actualiteService.getActualite(id);
        return actualite.map(actualite1 -> new ResponseEntity<>(ActualiteDTO.fromEntity(actualite1), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/tout")
    public ResponseEntity<List<ActualiteDTO>> getAllActualites(){
        List<Actualite> actualites=actualiteService.getAllActualites();
        return new ResponseEntity<>(ActualiteDTO.toDTOList(actualites),HttpStatus.OK);
    }
    @GetMapping("/etudiant")
    public ResponseEntity<List<ActualiteDTO>> getActualitesEtudiant(){
        List<Actualite> actualites=actualiteService.getActualitesByCible(CibleActualite.Etudiant);
        return new ResponseEntity<>(ActualiteDTO.toDTOList(actualites),HttpStatus.OK);
    }
    @GetMapping("/enseignant")
    public ResponseEntity<List<ActualiteDTO>> getActualitesEnseignant(){
        List<Actualite> actualites=actualiteService.getActualitesByCible(CibleActualite.Enseignant);
        return new ResponseEntity<>(ActualiteDTO.toDTOList(actualites),HttpStatus.OK);
    }

}
