package Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeConges;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demandeconges")
public class demandeCongesController {
    private final DemandeCongesService demandeCongesService;

    public demandeCongesController(DemandeCongesService demandeCongesService) {
        this.demandeCongesService = demandeCongesService;
    }

    @PostMapping("/ajouter")
    public ResponseEntity<DemandeConges> ajouterDemandeConges(@RequestBody DemandeCongesDTO congesDTO){
        DemandeConges conges=demandeCongesService.ajouterDemandeConges(congesDTO.toEntity());
        return new ResponseEntity<>(conges, HttpStatus.CREATED);
    }
    @PutMapping("/modifier/{id}")
    public ResponseEntity<DemandeConges> modifierDemandeConges(@PathVariable String id,@RequestBody DemandeCongesDTO congesDTO){
        DemandeConges demandeConges=demandeCongesService.getDemandeConges(id).get();
        demandeConges.setStatus(congesDTO.getStatus());
        demandeConges.setCommentaire(congesDTO.getCommentaire());
        demandeConges.setJour_deb(congesDTO.getJour_deb());
        demandeConges.setJour_fin(congesDTO.getJour_fin());
        demandeConges.setType(congesDTO.getType());
        demandeConges.setProprietaireCong(congesDTO.getProprietaireCong());
        demandeCongesService.modifierDemandeConges(demandeConges);
        return new ResponseEntity<>(demandeConges,HttpStatus.OK);
    }
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimerDemandeConges(@PathVariable("id") String id){
        demandeCongesService.supprimerDemandeConges(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemandeCongesDTO> getDemandeConges(@PathVariable("id") String id){
        Optional<DemandeConges> demandeConges=demandeCongesService.getDemandeConges(id);
        return demandeConges.map(demande -> new ResponseEntity<>(DemandeCongesDTO.fromEntity(demande), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/tout")
    public ResponseEntity<List<DemandeCongesDTO>> getAllDemandesConges(){
        List<DemandeConges> demandeConges=demandeCongesService.getAllDemandesConges();
        return new ResponseEntity<>(DemandeCongesDTO.toDTOList(demandeConges),HttpStatus.OK);
    }
    @PostMapping("/ajouterenseignant/{idDC}/{cin}/")
    public ResponseEntity<DemandeConges> ajouterEnseigantAuDemande(@PathVariable("idDC") String id,@PathVariable("cin") String cin){
        DemandeConges conges=demandeCongesService.ajouterEnseignantAuDemande(id,cin);
        return new ResponseEntity<>(conges,HttpStatus.OK);
    }
}
