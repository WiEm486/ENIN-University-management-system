package Miniprojet.MiniProjetBackend.Specialite;

import Miniprojet.MiniProjetBackend.Departement.Departement;
import Miniprojet.MiniProjetBackend.Departement.DepartementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialiteService {
    private final SpecialiteRepository specialiteRepository;
    private final DepartementRepository departementRepository;

    public SpecialiteService(SpecialiteRepository specialiteRepository, DepartementRepository departementRepository) {
        this.specialiteRepository = specialiteRepository;
        this.departementRepository = departementRepository;
    }

    public Specialite ajouterSpecialite(Specialite specialite){
        return specialiteRepository.save(specialite);
    }
    public Specialite modifierSpecialite(Specialite specialite){
        return specialiteRepository.save(specialite);
    }
    public void supprimerSpecialite(String nom){
        specialiteRepository.deleteById(nom);
    }
    public Specialite getSpecialite(String nom){
        return specialiteRepository.findById(nom).get();
    }
    public List<Specialite> getAllSpecialites(){
        return specialiteRepository.findAll();
    }

    public Departement ajouterSpecialiteauDepartement(String id_spec,String id_dep){
        Specialite specialite=specialiteRepository.findById(id_spec).get();
        Departement departement=departementRepository.findById(id_dep).get();
        List<Specialite> specialites=departement.getListeSpecialites();
        specialites.add(specialite);
        departement.setListeSpecialites(specialites);
        return departementRepository.save(departement);
    }
}
