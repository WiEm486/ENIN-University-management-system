package Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeEtudiant;

import Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeConges.DemandeConges;
import Miniprojet.MiniProjetBackend.DemandeAdministrative.DemandeConges.DemandeCongesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class DemandeEtudiantController {
    private final DemandeEtudiantService demandeEtudiantService;
    public DemandeEtudiantController(DemandeEtudiantService demandeEtudiantService) {
        this.demandeEtudiantService = demandeEtudiantService;
    }

    @PostMapping("/ajouter")
    public ResponseEntity<DemandeEtudiant> ajouterDemandeEtudiant(@RequestBody DemandeEtudiantDTO etudiantDTO){
        DemandeEtudiant demandeEtudiant=demandeEtudiantService.ajouterDemandeEtudiant(etudiantDTO.toEntity());
        return new ResponseEntity<>(demandeEtudiant, HttpStatus.CREATED);
    }
    @PutMapping("/modifier/{id}")
    public ResponseEntity<DemandeEtudiant> modifierDemandeEtudiant(@PathVariable String id, @RequestBody DemandeEtudiantDTO etudiantDTO){
        DemandeEtudiant demandeEtudiant=demandeEtudiantService.getDemandeEtudiant(id).get();
        demandeEtudiant.setStatus(etudiantDTO.getStatus());
        demandeEtudiant.setCommentaire(etudiantDTO.getCommentaire());
        demandeEtudiant.setMotif(etudiantDTO.getMotif());
        demandeEtudiant.setProprietaireEtu(etudiantDTO.getProprietaireEtu());
        demandeEtudiantService.modifierDemandeEtudiant(demandeEtudiant);
        return new ResponseEntity<>(demandeEtudiant,HttpStatus.OK);
    }
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimerDemandeEtudiant(@PathVariable("id") String id){
        demandeEtudiantService.supprimerDemandeEtudiant(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemandeEtudiantDTO> getDemandeEtudiant(@PathVariable("id") String id){
        Optional<DemandeEtudiant> demandeEtudiant=demandeEtudiantService.getDemandeEtudiant(id);
        return demandeEtudiant.map(demande -> new ResponseEntity<>(DemandeEtudiantDTO.fromEntity(demande), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/tout")
    public ResponseEntity<List<DemandeEtudiantDTO>> getAllDemandesEtudiant(){
        List<DemandeEtudiant> demandeEtudiant=demandeEtudiantService.getAllDemandesEtudiant();
        return new ResponseEntity<>(DemandeEtudiantDTO.toDTOList(demandeEtudiant),HttpStatus.OK);
    }
    @PostMapping("/ajouteretudiant/{idD}/{cin}")
    public ResponseEntity<DemandeEtudiant> ajouterEtudiantAuDemande(@PathVariable("idD") String id,@PathVariable("cin") String cin){
        DemandeEtudiant demandeEtudiant=demandeEtudiantService.ajouterEtudiantAuDemande(id,cin);
        return new ResponseEntity<>(demandeEtudiant,HttpStatus.OK);
    }
}
