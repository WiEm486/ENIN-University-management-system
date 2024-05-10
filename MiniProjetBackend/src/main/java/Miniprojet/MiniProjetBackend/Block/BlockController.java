package Miniprojet.MiniProjetBackend.Block;

import Miniprojet.MiniProjetBackend.Actualite.ActualiteDTO;
import Miniprojet.MiniProjetBackend.Salle.SalleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/block")
@CrossOrigin
public class BlockController {
    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }
    @PostMapping("/ajouter")
    public ResponseEntity<Block> ajouterBlock(BlockDTO blockDTO){
        Block block=blockService.ajouterBlock(blockDTO.toEntity());
        return new ResponseEntity<>(block, HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Block> modifierBlock(@PathVariable("id") String id, BlockDTO blockDTO){
        Block block1=blockService.getBlock(id).get();
        block1.setNb_salles(blockDTO.getNb_salles());
        block1.setListeSalles(SalleDTO.toEntityList(blockDTO.getListeSalles()));
        blockService.modifierBlock(block1);
        return new ResponseEntity<>(block1,HttpStatus.OK);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimerBlock(@PathVariable("id") String id){
        blockService.supprimerBlock(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlockDTO> getBlock(@PathVariable("id") String id){
        Optional<Block> block=blockService.getBlock(id);
        return block.map(block1 -> new ResponseEntity<>(BlockDTO.fromEntity(block1), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/tout")
    public ResponseEntity<List<BlockDTO>> getAllBlocks(){
        List<Block> blocks=blockService.getAllBlocks();
        return new ResponseEntity<>(BlockDTO.toDTOList(blocks),HttpStatus.OK);
    }

    @PutMapping("/ajoutersalle/{id_block}/{id_salle}")
    public ResponseEntity<BlockDTO> ajouterSalleAuBlock(@PathVariable("id_block") String idBlock,@PathVariable("id_salle") String idSalle){
        Block block=blockService.ajouterSalleAuBlock(idBlock,idSalle);
        return new ResponseEntity<>(BlockDTO.fromEntity(block),HttpStatus.OK);
    }
}
