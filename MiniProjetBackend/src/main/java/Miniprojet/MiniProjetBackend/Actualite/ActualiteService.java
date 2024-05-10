package Miniprojet.MiniProjetBackend.Actualite;

import Miniprojet.MiniProjetBackend.Ennumeration.CibleActualite;
import Miniprojet.MiniProjetBackend.Ennumeration.StatusActualite;
import Miniprojet.MiniProjetBackend.Ennumeration.TypeActualite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActualiteService {
    private final ActualiteRepository actualiteRepository;

    @Autowired
    public ActualiteService(ActualiteRepository actualiteRepository) {

        this.actualiteRepository = actualiteRepository;
    }

    public Actualite ajouterActuelite(ActualiteDTO actualiteDto) {

        Actualite act = actualiteDto.toEntity();
        return actualiteRepository.save(act);
    }
    public Actualite modifierActualite(String id, ActualiteDTO actualiteDTO){
        Optional<Actualite> act = actualiteRepository.findById(id);
        if (act.isPresent()){
            Actualite actualite = act.get();
            actualite.setCible(CibleActualite.fromString(actualiteDTO.getCible()));
            actualite.setType(TypeActualite.fromString(actualiteDTO.getType()));
            actualite.setContenu(actualiteDTO.getContenu());
            actualite.setTitre(actualiteDTO.getTitre());
            actualite.setStatus(StatusActualite.fromString(actualiteDTO.getStatus()));
            actualite.setDate_publication(actualiteDTO.getDate_publication());
            return actualite;
        }
        return null;
    }
    public void supprimerActualite(String id){
        actualiteRepository.deleteById(id);
    }
    public Optional<Actualite> getActualite(String id){
        return actualiteRepository.findById(id);
    }
    public List<Actualite> getAllActualites(){
        return actualiteRepository.findAll();
    }
    public List<Actualite> getActualitesByCible(CibleActualite cible){
        return actualiteRepository.findByCible(cible);
    }
    public List<Actualite> getActualitesByType(TypeActualite type){
        return actualiteRepository.findByType(type);
    }

    public Actualite updateStatus(Actualite actualite, StatusActualite status){
        actualite.setStatus(actualite.getStatus());
        return actualite;

    }
}
