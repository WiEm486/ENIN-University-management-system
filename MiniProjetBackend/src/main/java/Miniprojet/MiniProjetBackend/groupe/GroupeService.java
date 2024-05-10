package Miniprojet.MiniProjetBackend.groupe;

import Miniprojet.MiniProjetBackend.Ennumeration.Niveau;
import Miniprojet.MiniProjetBackend.Profile.Etudiant.EtudiantService;
import Miniprojet.MiniProjetBackend.Specialite.Specialite;
import Miniprojet.MiniProjetBackend.Specialite.SpecialiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class GroupeService {
    private final GroupeRepository groupeRepository;
    private final EtudiantService etudiantService;

    public GroupeService(GroupeRepository groupeRepository, EtudiantService etudiantService) {
        this.groupeRepository = groupeRepository;
        this.etudiantService = etudiantService;
    }


    public GroupeResponseDto create(GroupeRequestDto request){
        Groupe groupe =  Groupe.builder()
                .nom(request.getNom_groupe())
                .nb_etudiants(request.getNb_etudiants())
                .niveau(request.getNiveau())
                .speciality(request.getSpeciality())
                .build();
        return GroupeResponseDto.Entity2Dto(groupe);

    }

    public Optional<Groupe> getGroupeById(String id) {
        return groupeRepository.findById(id);
    }

    public List<Groupe> getAllGroupes() {
        return groupeRepository.findAll();
    }

    public List<Groupe> getAllGroupesByNiveau(Niveau niveau) {

        return groupeRepository.findAllByNiveau(niveau);
    }

    public List<Groupe> getAllGroupesBySpecialite(Specialite specialite) {
        return groupeRepository.findAllBySpeciality(specialite);
    }

    public List<Groupe> getAllGroupesBySpecialiteNiveau(Specialite specialite, Niveau niveau) {
        return groupeRepository.findAllBySpecialityAndNiveau(specialite, niveau);
    }

    public GroupeResponseDto updateGroupe(GroupeRequestDto groupedto){
        Optional<Groupe> groupeOptional = this.getGroupeById(groupedto.getId_groupe());
        if (groupeOptional.isPresent()){
            Groupe groupe = groupeOptional.get();
            groupe.setNom(groupedto.getNom_groupe());
            groupe.setNiveau(groupedto.getNiveau());
            groupe.setNb_etudiants(groupedto.getNb_etudiants());
            groupe.setSpeciality(groupedto.getSpeciality());
            groupeRepository.save(groupe);
            return GroupeResponseDto.Entity2Dto(groupe);
        }
        return null;
    }

    public void deleteGroupe(String id) {
        Optional<Groupe> groupeOptional = this.getGroupeById(id);
        if (groupeOptional.isPresent()) {
            Groupe groupe = groupeOptional.get();
            if (groupe.getEtudiants() != null) {
                groupe.getEtudiants().forEach(etudiant -> etudiantService.deleteEtudiant(etudiant.getCIN()));
            }
            groupeRepository.delete(groupe);
        }
    }


}
