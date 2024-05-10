package Miniprojet.MiniProjetBackend.LigneEmploi.Etude;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emlpoi")
@CrossOrigin
public class LigneEmploiEtudeController {

    private final LigneEmlpoiEtudeService ligneEmlpoiEtudeService;

    public LigneEmploiEtudeController(LigneEmlpoiEtudeService ligneEmlpoiEtudeService) {
        this.ligneEmlpoiEtudeService = ligneEmlpoiEtudeService;
    }

    @PostMapping("/new/{idEmploi}")
    public ResponseEntity<LigneEmploiEtudeDTO> create(@PathVariable String idEmploi,
                                                   @RequestBody LigneEmploiEtudeDTO ligneDto){
       LigneEmploiEtude ligEmploi =  ligneEmlpoiEtudeService.ajouterLigneEmploiEtude(idEmploi, ligneDto);
       return new ResponseEntity<>(LigneEmploiEtudeDTO.fromEntity(ligEmploi), HttpStatus.CREATED);

    }


}
