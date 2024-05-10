package Miniprojet.MiniProjetBackend.Salle;

import Miniprojet.MiniProjetBackend.Block.Block;
import Miniprojet.MiniProjetBackend.Block.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalleService {
    private final SalleRepository salleRepository;
    private final BlockRepository blockRepository;

    @Autowired
    public SalleService(SalleRepository salleRepository, BlockRepository blockRepository) {
        this.salleRepository = salleRepository;
        this.blockRepository = blockRepository;
    }
    public Salle ajouterSalle(Salle salle){
        return salleRepository.save(salle);
    }
    public Salle modifierSalle(Salle salle){
        return salleRepository.save(salle);
    }
    public void supprimerSalle(String id){
        salleRepository.deleteById(id);
    }

    public Optional<Salle> getSalle(String id) {
        return salleRepository.findById(id);
    }
    public List<Salle> getAllSalle(){
        return salleRepository.findAll();
    }

    public Salle ajouterSalleAuBlock(String idS,String idB){
        Block block=blockRepository.findById(idB).get();
        Salle salle=salleRepository.findById(idS).get();
        if(block==null || salle==null){
            return null;
        }
        salle.setBlock(block);
        return salleRepository.save(salle);
    }
}
