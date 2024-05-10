package Miniprojet.MiniProjetBackend.Matiere;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereService {

    private final MatiereRepository matiereRepository;

    public MatiereService(MatiereRepository matiereRepository) {
        this.matiereRepository = matiereRepository;
    }

    public List<Matiere> getAll() {
        return matiereRepository.findAll();

    }
}
