package Miniprojet.MiniProjetBackend.Block;

import Miniprojet.MiniProjetBackend.Salle.Salle;
import Miniprojet.MiniProjetBackend.Salle.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlockService {
    private final BlockRepository blockRepository;
    private final SalleRepository salleRepository;

    @Autowired
    public BlockService(BlockRepository blockRepository, SalleRepository salleRepository) {
        this.blockRepository = blockRepository;
        this.salleRepository = salleRepository;
    }

    public Block ajouterBlock(Block block){
        return blockRepository.save(block);
    }
    public Block modifierBlock(Block block){
        return blockRepository.save(block);
    }
    public void supprimerBlock(String id){
        blockRepository.deleteById(id);
    }
    public Optional<Block> getBlock(String id){
        return blockRepository.findById(id);
    }

    public List<Block> getAllBlocks(){
        return blockRepository.findAll();
    }

    public Block ajouterSalleAuBlock(String idBlock,String idSalle){
        Salle salle=salleRepository.findById(idSalle).get();
        Block block=blockRepository.findById(idBlock).get();
        List<Salle> salles= new ArrayList<>(block.getListeSalles());
        salles.add(salle);
        block.setListeSalles(salles);
        block.setNb_salles(block.getNb_salles()+1);
        return blockRepository.save(block);
    }
}
