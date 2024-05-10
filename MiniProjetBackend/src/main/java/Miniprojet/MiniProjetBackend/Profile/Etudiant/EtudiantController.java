package Miniprojet.MiniProjetBackend.Profile.Etudiant;

import Miniprojet.MiniProjetBackend.Ennumeration.Niveau;
import Miniprojet.MiniProjetBackend.Specialite.Specialite;
import Miniprojet.MiniProjetBackend.Specialite.SpecialiteService;
import Miniprojet.MiniProjetBackend.groupe.Groupe;
import Miniprojet.MiniProjetBackend.groupe.GroupeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    private final EtudiantService etudiantService;
    private final SpecialiteService specialiteService;
    private final GroupeService groupeService;

    public EtudiantController(EtudiantService etudiantService, SpecialiteService specialiteService,
                              GroupeService groupeService) {
        this.etudiantService = etudiantService;
        this.specialiteService = specialiteService;
        this.groupeService = groupeService;
    }
    @PostMapping("/ajouter")
    public ResponseEntity<EtudiantDTOResponse> ajouterEtudiant(@RequestBody EtudiantDTORequest etudiantDTORequest){
        EtudiantDTOResponse etudiantDTOResponse=etudiantService.createEtudiant(etudiantDTORequest);
        return new ResponseEntity<>(etudiantDTOResponse, HttpStatus.CREATED);
    }
    @DeleteMapping("/{cin}")
    public ResponseEntity<?> supprimerEtudiant(@PathVariable("cin") String cin){
        etudiantService.deleteEtudiant(cin);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{cin}")
    public ResponseEntity<EtudiantDTOResponse> getEtudiant(@PathVariable("cin")String cin){
        EtudiantDTOResponse etudiantDTOResponse=etudiantService.getEtudiantById(cin);
        return new ResponseEntity<>(etudiantDTOResponse,HttpStatus.OK);
    }
    @GetMapping("/tous")
    public ResponseEntity<List<EtudiantDTOResponse>> getAllEtudiant(){
        List<EtudiantDTOResponse> dtoResponses=etudiantService.getAllEtudiants();
        return new ResponseEntity<>(dtoResponses,HttpStatus.OK);
    }

    @GetMapping("/specialite/{id}")
    public ResponseEntity<List<EtudiantDTOResponse>> getAllEtudiantsBySpecialite(@PathVariable("id") String id){
        Specialite specialite=specialiteService.getSpecialite(id);
        List<EtudiantDTOResponse> dtoResponses=etudiantService.getAllEtudiantsBySpecialite(specialite);
        return new ResponseEntity<>(dtoResponses,HttpStatus.OK);
    }
    @GetMapping("/groupe/{id}")
    public ResponseEntity<List<EtudiantDTOResponse>> getAllEtudiantsByGroupe(@PathVariable("id") String id){
        Groupe groupe=groupeService.getGroupeById(id).get();
        List<EtudiantDTOResponse> dtoResponses=etudiantService.getAllEtudiantsByGroupe(groupe);
        return new ResponseEntity<>(dtoResponses,HttpStatus.OK);
    }
    @GetMapping("/{niveau}")
    public ResponseEntity<List<EtudiantDTOResponse>> getAllEtudiantsByNiveau(@PathVariable("niveau")Niveau niveau){
        List<EtudiantDTOResponse> dtoResponses=etudiantService.getAllEtudiantsByNiveau(niveau);
        return new ResponseEntity<>(dtoResponses,HttpStatus.OK);
    }

    @GetMapping("/specialite/{id}/{niveau}")
    public ResponseEntity<List<EtudiantDTOResponse>> getAllEtudiantsBySpecialiteAndNiveau(
            @PathVariable("id")String idS,
            @PathVariable("niveau")Niveau niveau){
        Specialite specialite=specialiteService.getSpecialite(idS);
        List<EtudiantDTOResponse> dtoResponses=etudiantService.getAllEtudiantsBySpecialiteAndNiveau(specialite,niveau);
        return new ResponseEntity<>(dtoResponses,HttpStatus.OK);
    }


}

