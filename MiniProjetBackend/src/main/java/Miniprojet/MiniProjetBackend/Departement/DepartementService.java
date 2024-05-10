package Miniprojet.MiniProjetBackend.Departement;

import Miniprojet.MiniProjetBackend.Profile.Enseignent.ChefDepartement.ChefDepartement;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.ChefDepartement.ChefDepartementRepository;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.Enseignant;
import Miniprojet.MiniProjetBackend.Profile.Enseignent.EnseignantRepository;
import Miniprojet.MiniProjetBackend.Salle.SalleRepository;
import Miniprojet.MiniProjetBackend.Specialite.Specialite;
import Miniprojet.MiniProjetBackend.Specialite.SpecialiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementService {
    private final DepartementRepository departementRepository;
    private final SpecialiteRepository specialiteRepository;
    private final EnseignantRepository enseignantRepository;
    private final ChefDepartementRepository chefDepartementRepository;

    public DepartementService(DepartementRepository departementRepository, SalleRepository salleRepository, SpecialiteRepository specialiteRepository, EnseignantRepository enseignentrepository, ChefDepartementRepository chefDepartementRepository) {
        this.departementRepository = departementRepository;
        this.specialiteRepository = specialiteRepository;
        this.enseignantRepository = enseignentrepository;
        this.chefDepartementRepository = chefDepartementRepository;
    }

    public Departement ajouterDepartement(Departement entity) {
        return departementRepository.save(entity);
    }

    public Optional<Departement> getDepartement(String id) {
        return departementRepository.findById(id);
    }

    public void supprimerDepartement(String id) {
        departementRepository.deleteById(id);
    }

    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    public Departement modifierDepartement(Departement departement) {
        return departementRepository.save(departement);
    }
    public Departement ajouterSpecialiteAuDepartement(String idD,String idS){
        Departement departement=departementRepository.findById(idD).get();
        Specialite specialite=specialiteRepository.findById(idS).get();
        List<Specialite> specialites=departement.getListeSpecialites();
        specialites.add(specialite);
        departement.setListeSpecialites(specialites);
        return departementRepository.save(departement);
    }
    public Departement ajouterEnseignantAuDepartement(String idD,String cin){
        Departement departement=departementRepository.findById(idD).get();
        Enseignant enseignant=enseignantRepository.findById(cin).get();
        List<Enseignant> enseignants=departement.getListeEnseignants();
        enseignants.add(enseignant);
        departement.setListeEnseignants(enseignants);
        return departementRepository.save(departement);
    }

    public Departement ajouterChefAuDepartement(String idD,String cin){
        Departement departement=departementRepository.findById(idD).get();
        ChefDepartement chef=chefDepartementRepository.findById(cin).get();
        departement.setChef(chef);
        return departementRepository.save(departement);
    }
}
