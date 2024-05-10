package Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeRattrapage;

import Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeEtudiant.DemandeEtudiant;
import Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeEtudiant.DemandeEtudiantDTO;
import Miniprojet.MiniProjetBackend.Ennumeration.StatusActualite;
import Miniprojet.MiniProjetBackend.Ennumeration.StatusDemande;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demanderattrapage")
@CrossOrigin
public class DemandeRattrapageController {
    private final DemandeRattrapageService demandeRattrapageService;

    public DemandeRattrapageController(DemandeRattrapageService demandeRattrapageService) {
        this.demandeRattrapageService = demandeRattrapageService;
    }
    @PostMapping("/ajouter/{id}")
    public ResponseEntity<DemandeRattrapage> ajouterDemandeRattrapage(@PathVariable String id, @RequestBody DemandeRattrapageDTO rattrapageDTO){
        DemandeRattrapage demandeRattrapage=demandeRattrapageService.ajouterDemandeRattrapage(rattrapageDTO);
        return new ResponseEntity<>(demandeRattrapage, HttpStatus.CREATED);
    }
    @PutMapping("/modifier/{id}")
    public ResponseEntity<DemandeRattrapageDTO> modifierDemandeRattrapage(
            @PathVariable String id,
            @RequestBody DemandeRattrapageDTO rattrapageDTO)
    {
        return new ResponseEntity<>(rattrapageDTO,HttpStatus.OK);
    }

    @PutMapping("/update/status/{id}")
    public ResponseEntity<DemandeRattrapageDTO> updateStatus(@PathVariable String id, @RequestBody String status){
        if (demandeRattrapageService.getDemandeRattrapage(id).isPresent()){
            DemandeRattrapage demande = demandeRattrapageService.getDemandeRattrapage(id).get();
            return new ResponseEntity<>(
                    DemandeRattrapageDTO.fromEntity(demandeRattrapageService.updateStatus(demande, StatusDemande.fromString(status))),
                    HttpStatus.OK
            );
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimerDemandeRattrapage(@PathVariable("id") String id){
        demandeRattrapageService.supprimerDemandeRattrapage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemandeRattrapageDTO> getDemandeRattrapage(@PathVariable("id") String id){
        Optional<DemandeRattrapage> demandeRattrapage=demandeRattrapageService.getDemandeRattrapage(id);
        return demandeRattrapage.map(demande -> new ResponseEntity<>(DemandeRattrapageDTO.fromEntity(demande), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @CrossOrigin
    @GetMapping("/tout")
    public ResponseEntity<List<DemandeRattrapageDTO>> getAllDemandesRattrapage(){
        List<DemandeRattrapage> demandeRattrapages=demandeRattrapageService.getAllDemandesRattrapage();
        return new ResponseEntity<>(DemandeRattrapageDTO.toDTOList(demandeRattrapages),HttpStatus.OK);
    }

    @PostMapping("/ajouterenseignant/{idD}/{cin}")
    public ResponseEntity<DemandeRattrapage> ajouterEnseignantAuDemande(@PathVariable("idD")String id,@PathVariable("cin") String cin){
        DemandeRattrapage demandeRattrapage=demandeRattrapageService.ajouterEnseignantAuDemande(id,cin);
        return new ResponseEntity<>(demandeRattrapage,HttpStatus.OK);
    }
    @PutMapping("/valider/{id}")
    public ResponseEntity<DemandeRattrapage> validerDemandeRattrapage(@PathVariable("id") String id){
        DemandeRattrapage rattrapage=demandeRattrapageService.getDemandeRattrapage(id).get();
        rattrapage.setStatus(StatusDemande.ACCEPTE);
        demandeRattrapageService.modifierDemandeRattrapage(rattrapage);
        return new ResponseEntity<>(rattrapage,HttpStatus.OK);
    }
    @PutMapping("/refuser/{id}")
    public ResponseEntity<DemandeRattrapage> refuserDemandeRattrapage(@PathVariable("id") String id){
        DemandeRattrapage rattrapage=demandeRattrapageService.getDemandeRattrapage(id).get();
        rattrapage.setStatus(StatusDemande.REFUSE);
        demandeRattrapageService.modifierDemandeRattrapage(rattrapage);
        return new ResponseEntity<>(rattrapage,HttpStatus.OK);
    }

}
