package Miniprojet.MiniProjetBackend.Profile.AdminScolarite;

import Miniprojet.MiniProjetBackend.Ennumeration.Role;
import Miniprojet.MiniProjetBackend.Profile.AdminEtudiant.AdminEtudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdminScolariteService{
    @Autowired
    private AdminScolariteRepository AS_repository;

    public  AdminScolarite saveAdminScolarite(AdminScolarite admin){
        return AS_repository.save(admin);
    }

    //Seul SuperAdmin peut créer un nouveau AdminScolrite
    public AdminScolarite createAdminScolarite(AdminScolariteDTO adminScolariteDTO) {
        AdminScolarite admin = new AdminScolarite();
        admin.setCIN(adminScolariteDTO.getCIN());
        admin.setEmail(adminScolariteDTO.getEmail());
        admin.setNom(adminScolariteDTO.getNom());
        admin.setPrenom(adminScolariteDTO.getPrenom());
        admin.setPassword(adminScolariteDTO.getPassword());
        admin.setDate_naissance(adminScolariteDTO.getDate_naissance());
        admin.setNum_tel(adminScolariteDTO.getNum_tel());
        admin.setAddresse(adminScolariteDTO.getAddresse());
        admin.setPhoto(adminScolariteDTO.getPhoto());
        //send Email
        admin.setRole(Role.ADMIN_SCOLARITE);
        return saveAdminScolarite(admin);
    }

    public AdminScolariteDTO updateAdminScolarite(AdminScolariteDTO adminScolariteDTO){
        if(getAdminScolarite(adminScolariteDTO.getCIN()).isPresent()){
            AdminScolarite admin = getAdminScolarite(adminScolariteDTO.getCIN()).get();
            admin.setEmail(adminScolariteDTO.getEmail());
            admin.setNom(adminScolariteDTO.getNom());
            admin.setPrenom(adminScolariteDTO.getPrenom());
            admin.setPassword(adminScolariteDTO.getPassword());
            admin.setDate_naissance(adminScolariteDTO.getDate_naissance());
            admin.setNum_tel(adminScolariteDTO.getNum_tel());
            admin.setAddresse(adminScolariteDTO.getAddresse());
            admin.setPhoto(adminScolariteDTO.getPhoto());
            return adminScolariteDTO;
        }

        return null;
    }

    //Par superAdmin
    public Optional<AdminScolarite> getAdminScolarite(String cin){
        return  AS_repository.findById(cin);
    }
    public List<AdminScolarite> getAllAdminScolarite(){
        return AS_repository.findAll();
    }

    public void deleteAdminScolarite(String cin){
        AS_repository.deleteById(cin);
    }
    public void deleteAllAdminScolarite(){
        AS_repository.deleteAll();
    }
    public int numberAdminScolarite(){
        return (int)AS_repository.count();
    }

}

