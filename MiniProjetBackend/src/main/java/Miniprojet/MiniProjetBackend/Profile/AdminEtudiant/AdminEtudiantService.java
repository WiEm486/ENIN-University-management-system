package Miniprojet.MiniProjetBackend.Profile.AdminEtudiant;

import Miniprojet.MiniProjetBackend.Ennumeration.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminEtudiantService {
    @Autowired
    private AdminEtudiantRepository AE_repository;

    public AdminEtudiant saveAdminEtudiant(AdminEtudiant admin){
        return AE_repository.save(admin);
    }

    //Seul SuperAdmin peut créer un nouveau AdminEtudiant
    public AdminEtudiant createAdminEtudiant(AdminEtudiantDTO adminEtudiantDTO) {
        AdminEtudiant admin = new AdminEtudiant();
        admin.setCIN(adminEtudiantDTO.getCIN());
        admin.setEmail(adminEtudiantDTO.getEmail());
        admin.setNom(adminEtudiantDTO.getNom());
        admin.setPrenom(adminEtudiantDTO.getPrenom());
        admin.setPassword(adminEtudiantDTO.getPassword());
        admin.setDate_naissance(adminEtudiantDTO.getDate_naissance());
        admin.setNum_tel(adminEtudiantDTO.getNum_tel());
        admin.setAddresse(adminEtudiantDTO.getAddresse());
        admin.setPhoto(adminEtudiantDTO.getPhoto());
        admin.setRole(Role.ADMIN_ETUDIANT);

        return saveAdminEtudiant(admin);
    }


    public AdminEtudiantDTO updateAdminEtudiant(AdminEtudiantDTO adminEtudiantDTO){
        if(getAdminEtudiant(adminEtudiantDTO.getCIN()).isPresent()){
            AdminEtudiant admin = getAdminEtudiant(adminEtudiantDTO.getCIN()).get();
            admin.setEmail(adminEtudiantDTO.getEmail());
            admin.setNom(adminEtudiantDTO.getNom());
            admin.setPrenom(adminEtudiantDTO.getPrenom());
            admin.setPassword(adminEtudiantDTO.getPassword());
            admin.setDate_naissance(adminEtudiantDTO.getDate_naissance());
            admin.setNum_tel(adminEtudiantDTO.getNum_tel());
            admin.setAddresse(adminEtudiantDTO.getAddresse());
            admin.setPhoto(adminEtudiantDTO.getPhoto());
            return adminEtudiantDTO;
        }

        return null;
    }
    public Optional<AdminEtudiant> getAdminEtudiant(String cin){
       return  AE_repository.findById(cin);
    }

    public List<AdminEtudiant> getAllAdminEtudiant(){
        return AE_repository.findAll();
    }

    public void deleteAdminEtudiant(String cin){
        AE_repository.deleteById(cin);
    }
    public void deleteAllAdminEtudiant(){
        AE_repository.deleteAll();
    }
    public int numberAdminScolarite(){
        return (int)AE_repository.count();
    }


}
