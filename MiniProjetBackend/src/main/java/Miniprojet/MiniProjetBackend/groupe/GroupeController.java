package Miniprojet.MiniProjetBackend.groupe;

import Miniprojet.MiniProjetBackend.Actualite.ActualiteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/groupe")
public class GroupeController {
    private final GroupeService groupeService;

    public GroupeController(GroupeService groupeService) {
        this.groupeService = groupeService;
    }

    @PostMapping("/ajouter")
    public ResponseEntity<GroupeResponseDto> ajouterGroupe(@RequestBody GroupeRequestDto groupeRequestDto){
        GroupeResponseDto groupe=groupeService.create(groupeRequestDto);
        return new ResponseEntity<>(groupe, HttpStatus.CREATED);
    }
    @PutMapping("/modifier/{id}")
    public ResponseEntity<GroupeResponseDto> modifierGroupe(@PathVariable("id") String id){
        Groupe groupe=groupeService.getGroupeById(id).get();
        //GroupeResponseDto groupeResponseDto=groupeService.updateGroupe(GroupeRequestDto::)
        return null;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimerGroupe(@PathVariable("id")String id){
        groupeService.deleteGroupe(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupeResponseDto> getGroupe(@PathVariable("id") String id){
        Optional<Groupe> groupe=groupeService.getGroupeById(id);
        return groupe.map(groupe1 -> new ResponseEntity<>(GroupeResponseDto.fromEntity(groupe1), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
