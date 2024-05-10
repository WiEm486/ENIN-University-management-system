package Miniprojet.MiniProjetBackend.Profile.SuperAdmin;

import Miniprojet.MiniProjetBackend.Profile.AdminDto;
import Miniprojet.MiniProjetBackend.Profile.AdminEtudiant.AdminEtudiant;
import Miniprojet.MiniProjetBackend.Profile.AdminEtudiant.AdminEtudiantDTO;
import Miniprojet.MiniProjetBackend.Profile.AdminEtudiant.AdminEtudiantService;
import Miniprojet.MiniProjetBackend.Profile.AdminScolarite.AdminScolarite;
import Miniprojet.MiniProjetBackend.Profile.AdminScolarite.AdminScolariteDTO;
import Miniprojet.MiniProjetBackend.Profile.AdminScolarite.AdminScolariteRepository;
import Miniprojet.MiniProjetBackend.Profile.AdminScolarite.AdminScolariteService;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.ChefDepartement.ChefDepartement;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.ChefDepartement.ChefDepartementDto;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.ChefDepartement.ChefDepartementService;
import org.hibernate.annotations.Check;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SuperAdminService {
    private final SuperAdminRepository SA_repository;
    private final AdminScolariteService adminScolariteService;

    private final AdminEtudiantService adminEtudiantService;
    private final ChefDepartementService chefDepartementService;

    public SuperAdminService(SuperAdminRepository saRepository, AdminScolariteService adminScolariteService, AdminEtudiantService adminEtudiantService, ChefDepartementService chefDepartementService) {
        this.SA_repository = saRepository;
        this.adminScolariteService = adminScolariteService;
        this.adminEtudiantService = adminEtudiantService;
        this.chefDepartementService = chefDepartementService;
    }

    public Optional<SuperAdmin> getSuperAdmin(String cin){
        return  SA_repository.findById(cin);
    }

    public SuperAdmin updateSuperAdmin(String cin, SuperAdmin superAdmin) {
        SuperAdmin admin = this.getSuperAdmin(cin).get();
        admin.setNom(superAdmin.getNom());
        admin.setPrenom(superAdmin.getPrenom());
        admin.setEmail(superAdmin.getEmail());
        admin.setPassword(superAdmin.getPassword());
        admin.setAddresse(superAdmin.getAddresse());
        admin.setPhoto(superAdmin.getPhoto());
        admin.setDate_naissance(superAdmin.getDate_naissance());
        admin.setNum_tel(superAdmin.getNum_tel());
        return admin;
    }

//    public List<AdminDto> getAllAdmins(){
//        List<AdminEtudiant> adminsE = adminEtudiantService.getAllAdminEtudiant();
//        List<AdminEtudiantDTO> DtoAdminsE = AdminEtudiantDTO.toDTOList(adminsE);
//        List<AdminDto> adminsDtoE = DtoAdminsE.stream().map(AdminEtudiantDTO::toAdminDto).collect(Collectors.toList());
//
//        List<AdminScolarite> adminsS = adminScolariteService.getAllAdminScolarite();
//        List<AdminScolariteDTO> DtoAdminsS = AdminScolariteDTO.toDTOList(adminsS);
//        List<AdminDto> adminsDtoS = DtoAdminsS.stream().map(AdminScolariteDTO::toAdminDto).collect(Collectors.toList());
//
//        List<ChefDepartement> chefs = chefDepartementService.getAllChefs();
//        List<ChefDepartementDto> DtoChefs = ChefDepartementDto.toDTOList(chefs);
//        List<AdminDto> chefsDtoS = DtoChefs.stream().map(ChefDepartementDto::toAdminDto).collect(Collectors.toList());
//
//    }

    public List<AdminDto> getAllAdmins() {
        List<AdminDto> allAdmins = new ArrayList<>();

        List<AdminEtudiant> adminsE = adminEtudiantService.getAllAdminEtudiant();
        List<AdminEtudiantDTO> DtoAdminsE = AdminEtudiantDTO.toDTOList(adminsE);
        List<AdminDto> adminsDtoE = DtoAdminsE.stream().map(AdminEtudiantDTO::toAdminDto).collect(Collectors.toList());
        allAdmins.addAll(adminsDtoE);

        List<AdminScolarite> adminsS = adminScolariteService.getAllAdminScolarite();
        List<AdminScolariteDTO> DtoAdminsS = AdminScolariteDTO.toDTOList(adminsS);
        List<AdminDto> adminsDtoS = DtoAdminsS.stream().map(AdminScolariteDTO::toAdminDto).collect(Collectors.toList());
        allAdmins.addAll(adminsDtoS);

        List<ChefDepartement> chefs = chefDepartementService.getAllChefs();
        List<ChefDepartementDto> DtoChefs = ChefDepartementDto.toDTOList(chefs);
        List<AdminDto> chefsDtoS = DtoChefs.stream().map(ChefDepartementDto::toAdminDto).collect(Collectors.toList());
        allAdmins.addAll(chefsDtoS);

        return allAdmins;
    }

}
