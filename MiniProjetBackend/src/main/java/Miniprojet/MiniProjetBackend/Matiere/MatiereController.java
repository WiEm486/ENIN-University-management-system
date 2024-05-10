package Miniprojet.MiniProjetBackend.Matiere;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matiere")
@CrossOrigin
public class MatiereController {
    private final MatiereService matiereService;

    public MatiereController(MatiereService matiereService) {
        this.matiereService = matiereService;
    }

    @GetMapping("/tout")
    public ResponseEntity<List<MatiereDTO>> getAll(){
        List<Matiere> matieres =  matiereService.getAll();
        return new ResponseEntity<>(MatiereDTO.toDTOList(matieres), HttpStatus.OK) ;
    }
}
