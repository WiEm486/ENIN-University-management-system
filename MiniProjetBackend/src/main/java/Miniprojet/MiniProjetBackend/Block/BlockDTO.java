package Miniprojet.MiniProjetBackend.Block;

import Miniprojet.MiniProjetBackend.Salle.Salle;
import Miniprojet.MiniProjetBackend.Salle.SalleDTO;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class BlockDTO {
    //private String id_block;
    private Integer nb_salles;
    private List<SalleDTO> ListeSalles;

    public static BlockDTO fromEntity(Block block) {
        BlockDTO blockDTO=new BlockDTO();
        //blockDTO.setId_block(block.getId_block());
        blockDTO.setNb_salles(block.getNb_salles());
        blockDTO.setListeSalles(SalleDTO.toDTOList(block.getListeSalles()));
        return blockDTO;
    }
    public Block toEntity(){
        Block block=new Block();
        //block.setId_block(this.getId_block());
        block.setNb_salles(this.getNb_salles());
        block.setListeSalles(SalleDTO.toEntityList(this.getListeSalles()));
        return block;
    }
    // Static method to convert list of entities to list of DTOs
    public static List<BlockDTO> toDTOList(List<Block> blocks) {
        return blocks.stream().map(BlockDTO::fromEntity).collect(Collectors.toList());
    }
    public static List<Block> toEntityList(List<BlockDTO> dtos) {
        return dtos.stream().map(BlockDTO::toEntity).collect(Collectors.toList());
    }

}
