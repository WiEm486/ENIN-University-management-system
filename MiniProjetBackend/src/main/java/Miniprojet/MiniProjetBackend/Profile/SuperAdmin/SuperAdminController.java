package Miniprojet.MiniProjetBackend.Profile.SuperAdmin;

import Miniprojet.MiniProjetBackend.Profile.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/super")
public class SuperAdminController {
    @Autowired
    private final SuperAdminService superAdminService;

    public SuperAdminController(SuperAdminService superAdminService) {
        this.superAdminService = superAdminService;
    }


    @GetMapping("/get/{cin}")
    public ResponseEntity<SuperAdmin> getSuperAdmin(@PathVariable String cin){
        if (superAdminService.getSuperAdmin(cin).isPresent())
        {
            return new ResponseEntity<>(superAdminService.getSuperAdmin(cin).get(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    };

    @PutMapping("edit/{cin}")
    public ResponseEntity<SuperAdmin> updateSuperAdmin(@PathVariable String cin, @RequestBody SuperAdmin superAdmin){
        if (cin.equals(superAdmin.getCIN()) && superAdminService.getSuperAdmin(cin).isPresent())
        {
            return new ResponseEntity<>(superAdminService.updateSuperAdmin(cin, superAdmin), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/admins")
    public ResponseEntity<List<AdminDto>> getAllAdmins(){
        List<AdminDto> all = superAdminService.getAllAdmins();
        if (all.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(all, HttpStatus.OK);
    }

}
