package Miniprojet.MiniProjetBackend.Salle;

import Miniprojet.MiniProjetBackend.Block.BlockDTO;
import Miniprojet.MiniProjetBackend.LigneEmploi.Etude.LigneEmploiEtudeDTO;
import Miniprojet.MiniProjetBackend.LigneEmploi.Examen.LigneEmploiExamenDTO;
import Miniprojet.MiniProjetBackend.LigneEmploi.Rattrapage.LigneEmploiRattrapageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salle")
public class SalleController {
    private final SalleService salleService;

    @Autowired
    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Salle> ajouterSalle(@RequestBody SalleDTO salleDTO){
        Salle salle=salleService.ajouterSalle(salleDTO.toEntity());
        return new ResponseEntity<>(salle, HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Salle> modifierSalle(@PathVariable("id")String id,SalleDTO salleDTO){
        Salle salle=salleService.getSalle(id).get();
        salle.setNoms(salleDTO.getNom_salle());
        salle.setType(salleDTO.getType());
        salle.setBlock(salleDTO.getBlock().toEntity());
        salle.setLignes_emploi_ex(LigneEmploiExamenDTO.toEntityList(salleDTO.getLignes_emploi_ex()));
        //salle.setLignes_emploi_et(LigneEmploiEtudeDTO.toEntityList(salleDTO.getLignes_emploi_et()));
        salle.setLignes_emploi_R(LigneEmploiRattrapageDTO.toEntityList(salleDTO.getLignes_emploi_R()));
        salleService.modifierSalle(salle);
        return new ResponseEntity<>(salle,HttpStatus.OK);
    }
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimerSalle(@PathVariable("id") String id){
        salleService.supprimerSalle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalleDTO> getSalle(@PathVariable("id")String id){
        Optional<Salle> salle=salleService.getSalle(id);
        return salle.map(salle1 -> new ResponseEntity<>(SalleDTO.fromEntity(salle1), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/tous")
    public ResponseEntity<List<SalleDTO>> getAllSalles(){
        List<Salle> salles=salleService.getAllSalle();
        return new ResponseEntity<>(SalleDTO.toDTOList(salles),HttpStatus.OK);
    }
    @PutMapping("/ajouterblock/{idS}/{idB}")
    public ResponseEntity<Salle> ajouterBlockAuSalle(@PathVariable("idS")String idS,@PathVariable("idB")String idB){
        Salle salle=salleService.ajouterSalleAuBlock(idS,idB);
        return new ResponseEntity<>(salle,HttpStatus.OK);
    }


}
