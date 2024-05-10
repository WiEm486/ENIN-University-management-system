package Miniprojet.MiniProjetBackend.Profile.AdminScolarite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins/adminscolarite") // Base URL mapping for this controller
@CrossOrigin
public class AdminScolariteController {
    @Autowired
    private AdminScolariteService adminScolariteService;

    //Receiving a JSON payload representing the AdminScolariteDto.
    @PostMapping("/new")
    public ResponseEntity<AdminScolarite> createAdminScolarite(@RequestBody AdminScolariteDTO adminDto) {
        AdminScolarite admin = adminScolariteService.createAdminScolarite(adminDto);
        return new ResponseEntity<>(admin, HttpStatus.CREATED);
    }

    @GetMapping("/{cin}")
    public ResponseEntity<AdminScolariteDTO> getAdminScolarite(@PathVariable String cin) {
        Optional<AdminScolarite> adminOptional = adminScolariteService.getAdminScolarite(cin);
        return adminOptional.map(admin -> new ResponseEntity<>(AdminScolariteDTO.fromEntity(admin), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AdminScolariteDTO>> getAllAdminScolarite() {
        List<AdminScolarite> admins = adminScolariteService.getAllAdminScolarite();
        return new ResponseEntity<>(AdminScolariteDTO.toDTOList(admins), HttpStatus.OK);
    }

    //update Profile
    @PutMapping("/{cin}")
    public ResponseEntity<AdminScolariteDTO> updateAdminScolarite(@PathVariable String cin, @RequestBody AdminScolariteDTO adminDto) {
        if (cin.equals(adminDto.getCIN())){
            AdminScolariteDTO admin = adminScolariteService.updateAdminScolarite(adminDto);
            if (admin != null)
                return new ResponseEntity<>(admin, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}

