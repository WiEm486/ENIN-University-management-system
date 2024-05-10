package Miniprojet.MiniProjetBackend.Profile.Enseignent.ChefDepartement;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChefDepartementService {
    private final ChefDepartementRepository chefDepartementRepository;

    public ChefDepartementService(ChefDepartementRepository chefDepartementRepository) {
        this.chefDepartementRepository = chefDepartementRepository;
    }

    public List<ChefDepartement> getAllChefs(){
        return chefDepartementRepository.findAll();
    }
}
