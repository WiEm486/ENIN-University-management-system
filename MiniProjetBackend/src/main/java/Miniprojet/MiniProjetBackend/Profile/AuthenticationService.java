package Miniprojet.MiniProjetBackend.Profile;

import Miniprojet.MiniProjetBackend.Profile.AdminEtudiant.AdminEtudiant;
import Miniprojet.MiniProjetBackend.Profile.AdminEtudiant.AdminEtudiantRepository;
import Miniprojet.MiniProjetBackend.Profile.AdminScolarite.AdminScolarite;
import Miniprojet.MiniProjetBackend.Profile.AdminScolarite.AdminScolariteRepository;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.ChefDepartement.ChefDepartement;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.ChefDepartement.ChefDepartementRepository;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.EnseignantRepository;
import Miniprojet.MiniProjetBackend.Profile.Etudiant.Etudiant;
import Miniprojet.MiniProjetBackend.Profile.Etudiant.EtudiantRepository;
import Miniprojet.MiniProjetBackend.Profile.SuperAdmin.SuperAdmin;
import Miniprojet.MiniProjetBackend.Profile.SuperAdmin.SuperAdminRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final SuperAdminRepository superAdminRepository;
    private final AdminEtudiantRepository adminEtudiantRepository;
    private final AdminScolariteRepository adminScolariteRepository;
    private final EnseignantRepository enseignentrepository;
    private final ChefDepartementRepository chefDepartementRepository;
    private final EtudiantRepository etudiantRepository;

    public AuthenticationService(SuperAdminRepository superAdminRepository,
                                 AdminEtudiantRepository adminEtudiantRepository,
                                 AdminScolariteRepository adminScolariteRepository,
                                 EnseignantRepository enseignentrepository,
                                 ChefDepartementRepository chefDepartementRepository,
                                 EtudiantRepository etudiantRepository) {
        this.superAdminRepository = superAdminRepository;
        this.adminEtudiantRepository = adminEtudiantRepository;
        this.adminScolariteRepository = adminScolariteRepository;
        this.enseignentrepository = enseignentrepository;
        this.chefDepartementRepository = chefDepartementRepository;
        this.etudiantRepository = etudiantRepository;
    }


    public Profile loadUserByUsername(String email, String pwd) {

        Optional<SuperAdmin> superAdmin = superAdminRepository.findByEmail(email);
        if (superAdmin.isPresent()) {
            SuperAdmin superA = superAdmin.get();
            if (superA.getPassword().equals(pwd)) {
                return superA;
            }
        } else {
            Optional<AdminEtudiant> adminE = adminEtudiantRepository.findByEmail(email);
            if (adminE.isPresent()) {
                AdminEtudiant admin = adminE.get();
                if (admin.getPassword().equals(pwd)) {
                    return admin;
                }
            } else {
                // Test for AdminScolarite
                Optional<AdminScolarite> adminS = adminScolariteRepository.findByEmail(email);
                if (adminS.isPresent()) {
                    AdminScolarite admin = adminS.get();
                    if (admin.getPassword().equals(pwd)) {
                        return admin;
                    }
                } else {
                    Optional<Enseignant> enseignant = enseignentrepository.findByEmail(email);
                    if (enseignant.isPresent()) {
                        Enseignant ens = enseignant.get();
                        if (ens.getPassword().equals(pwd)) {
                            return ens;
                        }
                    } else {
                        Optional<ChefDepartement> chef = chefDepartementRepository.findByEmail(email);
                        if (chef.isPresent()) {
                            ChefDepartement chefD = chef.get();
                            if (chefD.getPassword().equals(pwd)) {
                                return chefD;
                            }
                        } else {
                            Optional<Etudiant> etudiant = etudiantRepository.findByEmail(email);
                            if (etudiant.isPresent()) {
                                Etudiant student = etudiant.get();
                                if (student.getPassword().equals(pwd)) {
                                    return student;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }





    public String getRedirectUrl(Profile user) {
        String role = user.getRole().getStringValue();
        String cin = user.getCIN();

        // Generate the redirect URL based on the user's role and cin
        String redirectUrl = "";
        switch (role) {
            case "SuperAdmin":
                redirectUrl = "/superadmin/" + cin;
                break;
            case "AdminEtudiant":
                redirectUrl = "/adminetudiant/" + cin;
                break;
            case "AdminScolarite":
                redirectUrl = "/adminscolarite/" + cin;
                break;
            case "Enseignant":
                redirectUrl = "/actualite/enseignant/" + cin;
                break;
            case "ChefDepartement":
                redirectUrl = "/chefdepartement/" + cin;
                break;
            case "Etudiant":
                redirectUrl = "/actualite/etudiant/" + cin;
                break;
            default:
                break;
        }
        return redirectUrl;
    }

}
