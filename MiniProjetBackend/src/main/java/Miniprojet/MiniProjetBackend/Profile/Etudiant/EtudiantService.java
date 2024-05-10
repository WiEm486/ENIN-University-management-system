package Miniprojet.MiniProjetBackend.Profile.Etudiant;

import Miniprojet.MiniProjetBackend.Ennumeration.Niveau;
import Miniprojet.MiniProjetBackend.Ennumeration.Role;
import Miniprojet.MiniProjetBackend.Specialite.Specialite;
import Miniprojet.MiniProjetBackend.groupe.Groupe;
import Miniprojet.MiniProjetBackend.groupe.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;
    private GroupeService groupeService;

    //Appelé par l'admin Etudiant
    public EtudiantDTOResponse createEtudiant(EtudiantDTORequest etudiantDTO) {
        Etudiant etudiant = new Etudiant();

        etudiant.setNum_inscription(etudiantDTO.getNum_inscription());
        etudiant.setCIN(etudiantDTO.getCIN());
        etudiant.setEmail(etudiantDTO.getEmail());
        etudiant.setNom(etudiantDTO.getNom());
        etudiant.setPrenom(etudiantDTO.getPrenom());
        etudiant.setRole(Role.ETUDIANT);
        etudiant.setGroupe(etudiantDTO.getGroupe());
        etudiantRepository.save(etudiant);
        return EtudiantDTOResponse.Entity2Dto(etudiant);
    }

    //Appelé par l'Admin
    public EtudiantDTOResponse getEtudiantById(String cin) {
        Etudiant etudiant = etudiantRepository.findById(cin).orElse(null);
        EtudiantDTOResponse dto = EtudiantDTOResponse.Entity2Dto(etudiant);
        return dto;
    }

    // A modifier par l'etudiant lui-meme
    public EtudiantDtoUpdate updateEtudiant(EtudiantDtoUpdate update_request){
        Etudiant etudiant = etudiantRepository.findById(update_request.getCIN()).orElse(null);
        if (etudiant != null) {
            etudiant.setAddresse(update_request.getAddresse());
            etudiant.setDate_naissance(update_request.getDate_naissance());
            etudiant.setPassword(update_request.getMot_de_passe());
            etudiant.setNum_tel(update_request.getNum_tel());
            etudiant.setPhoto(update_request.getPhoto());

            etudiantRepository.save(etudiant);
            return update_request;
        }
        return null;
    }

    // A modifier par l'admin
    public EtudiantDTOResponse updateEtudiant(EtudiantDTORequest etudiantDTO){
        Etudiant etudiant = etudiantRepository.findById(etudiantDTO.getCIN()).orElse(null);
        if(etudiant != null){
        etudiant.setNum_inscription(etudiantDTO.getNum_inscription());
        etudiant.setCIN(etudiantDTO.getCIN());
        etudiant.setEmail(etudiantDTO.getEmail());
        etudiant.setNom(etudiantDTO.getNom());
        etudiant.setPrenom(etudiantDTO.getPrenom());
        etudiantRepository.save(etudiant);
        return EtudiantDTOResponse.Entity2Dto(etudiant);
        }
        return null;
    }

    public List<EtudiantDTOResponse> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        return EtudiantDTOResponse.toDtoResponseList(etudiants);
    }
    public List<EtudiantDTOResponse> getAllEtudiantsByGroupe(Groupe groupe) {
        Optional<List<Etudiant>> etudiants = etudiantRepository.findAllByGroupe(groupe);
        if (etudiants.isPresent())
            return EtudiantDTOResponse.toDtoResponseList(etudiants.get());
        else
            return null;
    }


    public void deleteEtudiant(String cin){
        Optional<Etudiant> etudiantOptional = etudiantRepository.findById(cin);
        etudiantOptional.ifPresent(etudiant -> etudiantRepository.delete(etudiant));
    }

    public List<EtudiantDTOResponse> getAllEtudiantsBySpecialite(Specialite specialite) {
        List<Groupe> groups = groupeService.getAllGroupesBySpecialite(specialite);
        List<Etudiant> etudiants = new ArrayList<>();
        groups.forEach(groupe -> {
            etudiants.addAll(groupe.getEtudiants());
        });
        return EtudiantDTOResponse.toDtoResponseList(etudiants);
    }

    public List<EtudiantDTOResponse> getAllEtudiantsByNiveau(Niveau niveau) {
        List<Groupe> groups = groupeService.getAllGroupesByNiveau(niveau);
        List<Etudiant> etudiants = new ArrayList<>();
        groups.forEach(groupe -> {
            etudiants.addAll(groupe.getEtudiants());
        });
        return EtudiantDTOResponse.toDtoResponseList(etudiants);
    }

    public List<EtudiantDTOResponse> getAllEtudiantsBySpecialiteAndNiveau(Specialite specialite, Niveau niveau){
        List<Groupe> groups = groupeService.getAllGroupesBySpecialiteNiveau(specialite, niveau);
        List<Etudiant> etudiants = new ArrayList<>();
        groups.forEach(groupe -> {
            etudiants.addAll(groupe.getEtudiants());
        });
        return EtudiantDTOResponse.toDtoResponseList(etudiants);
    }

}
