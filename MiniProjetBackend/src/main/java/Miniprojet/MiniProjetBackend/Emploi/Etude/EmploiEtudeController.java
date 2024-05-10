package Miniprojet.MiniProjetBackend.Emploi.Etude;

import Miniprojet.MiniProjetBackend.Actualite.ActualiteDTO;
import Miniprojet.MiniProjetBackend.LigneEmploi.Etude.LigneEmploiEtudeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emploietude")
public class EmploiEtudeController {
    private final EmploiEtudeService emploiEtudeService;

    public EmploiEtudeController(EmploiEtudeService emploiEtudeService) {
        this.emploiEtudeService = emploiEtudeService;
    }

    @PostMapping("/ajouter")
    public ResponseEntity<EmploiEtude> ajouterEmploietude(@RequestBody EmploiEtudeDTO emploiEtudeDTO){
        EmploiEtude emploiEtude=emploiEtudeService.ajouterEmploiEtude(emploiEtudeDTO.toEntity());
        return new ResponseEntity<>(emploiEtude, HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<EmploiEtude> modifierEmploiEtude(@PathVariable("id") String id,EmploiEtudeDTO emploiEtudeDTO ){
        EmploiEtude emploiEtude=emploiEtudeService.getEmploiEtude(id).get();
        emploiEtude.setGroupe(emploiEtudeDTO.getGroupe().toEntity());
        emploiEtude.setSeme(emploiEtudeDTO.getSeme());
        emploiEtude.setAnnee_univ(emploiEtudeDTO.getAnnee_univ());
        //emploiEtude.setLignes(LigneEmploiEtudeDTO.toEntityList(emploiEtudeDTO.getLignes()));
        emploiEtudeService.modifierEmploiEtude(emploiEtude);
        return new ResponseEntity<>(emploiEtude,HttpStatus.OK);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimerEmploiEtude(@PathVariable("id") String id){
        emploiEtudeService.supprimerEmploiEtude(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploiEtudeDTO> getEmploiEtude(@PathVariable("id") String id){
        Optional<EmploiEtude> emploiEtude=emploiEtudeService.getEmploiEtude(id);
        return emploiEtude.map(emploiEtude1 -> new ResponseEntity<>(EmploiEtudeDTO.fromEntity(emploiEtude1), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/tous")
    public ResponseEntity<List<EmploiEtudeDTO>> getAllEmploiEtude(){
        List<EmploiEtude> emploiEtudes=emploiEtudeService.getAllEmploietude();
        return new ResponseEntity<>(EmploiEtudeDTO.toDTOList(emploiEtudes),HttpStatus.OK);
    }
}
