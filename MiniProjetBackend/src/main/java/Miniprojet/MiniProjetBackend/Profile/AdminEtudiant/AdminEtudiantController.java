package Miniprojet.MiniProjetBackend.Profile.AdminEtudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/admins/adminetudiant") // Base URL mapping for this controller
public class AdminEtudiantController {
    @Autowired
    private AdminEtudiantService adminEtudiantService;

    @PostMapping("/new")
    public ResponseEntity<AdminEtudiant> createAdminEtudiant(@RequestBody AdminEtudiantDTO adminDto) {
        AdminEtudiant admin = adminEtudiantService.createAdminEtudiant(adminDto);
        return new ResponseEntity<>(admin, HttpStatus.CREATED);
    }

    @GetMapping("/{cin}")
    public ResponseEntity<AdminEtudiantDTO> getAdminEtudiant(@PathVariable String cin) {
        Optional<AdminEtudiant> adminOptional = adminEtudiantService.getAdminEtudiant(cin);
        return adminOptional.map(admin -> new ResponseEntity<>(AdminEtudiantDTO.fromEntity(admin), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AdminEtudiantDTO>> getAllAdminEtudiant() {
        List<AdminEtudiant> admins = adminEtudiantService.getAllAdminEtudiant();
        return new ResponseEntity<>(AdminEtudiantDTO.toDTOList(admins), HttpStatus.OK);
    }

    //update Profile
    @PutMapping("/{cin}")
    public ResponseEntity<AdminEtudiantDTO> updateAdminEtudiant(@PathVariable String cin,
                                                                @RequestBody AdminEtudiantDTO adminDto) {
        if (cin.equals(adminDto.getCIN())){
            AdminEtudiantDTO admin = adminEtudiantService.updateAdminEtudiant(adminDto);
            if (admin != null)
                return new ResponseEntity<>(admin, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}

