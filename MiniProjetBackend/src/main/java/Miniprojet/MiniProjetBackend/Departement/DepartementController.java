package Miniprojet.MiniProjetBackend.Departement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departement")
@CrossOrigin
public class DepartementController {
    private final DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Departement> ajouterDepartement(@RequestBody DepartementDTO departementDTO){
        Departement departement=departementService.ajouterDepartement(departementDTO.toEntity());
        return new ResponseEntity<>(departement, HttpStatus.CREATED);
    }
    @PutMapping("/modifier/{id}")
    public ResponseEntity<Departement> modifierDepartement(@PathVariable String id, @RequestBody DepartementDTO departementDTO){
        Departement departement=departementService.getDepartement(id).get();
        departement.setDepartement(departementDTO.getDepartement());
        departement.setDescription(departementDTO.getDescription());
        departement.setChef(departementDTO.getChef());
        departement.setListeEnseignants(departementDTO.getListeEnseignants());
        departement.setListeSpecialites(departementDTO.getListeSpecialites());
        departementService.modifierDepartement(departement);
        return new ResponseEntity<>(departement,HttpStatus.OK);
    }
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimerDepartement(@PathVariable("id") String id){
        departementService.supprimerDepartement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartementDTO> getDepartement(@PathVariable("id") String id){
        Optional<Departement> departement=departementService.getDepartement(id);
        return departement.map(departement1 -> new ResponseEntity<>(DepartementDTO.fromEntity(departement1), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/tout")
    public ResponseEntity<List<DepartementDTO>> getAllDepartements(){
        List<Departement> departements=departementService.getAllDepartements();
        return new ResponseEntity<>(DepartementDTO.toDTOList(departements),HttpStatus.OK);
    }
    @PostMapping("/ajouterspecialite/{idD}/{idS}")
    public ResponseEntity<Departement> ajouterSpecialiteAuDepartement(@PathVariable("idD") String idD,@PathVariable("idS")String idS){
        Departement departement=departementService.ajouterSpecialiteAuDepartement(idD,idS);
        return new ResponseEntity<>(departement,HttpStatus.OK);
    }
    @PostMapping("/ajouterenseignant/{idD}/{cin}")
    public ResponseEntity<Departement> ajouterEnseignantAuDepartement(@PathVariable("idD")String idD,@PathVariable("cin")String cin){
        Departement departement=departementService.ajouterEnseignantAuDepartement(idD,cin);
        return new ResponseEntity<>(departement,HttpStatus.OK);
    }
    @PostMapping("/ajouterchef/{idD}/{cin}")
    public ResponseEntity<Departement> ajouterChefAuDepartement(@PathVariable("idD")String idD,@PathVariable("cin")String cin){
        Departement departement=departementService.ajouterChefAuDepartement(idD,cin);
        return new ResponseEntity<>(departement,HttpStatus.OK);
    }
}
