package Miniprojet.MiniProjetBackend.Profile;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/auth")
@CrossOrigin
public class LoginController {

    private final AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    // Adjust this to match your React app's URL
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Credentials creds) {
        System.out.println("okayyy");
        Profile user = authenticationService.loadUserByUsername(creds.getEmail(), creds.getPassword());
        if (user != null) {
            // You can return user profile data directly if needed
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
