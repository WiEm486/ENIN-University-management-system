package Miniprojet.MiniProjetBackend.Suivi;


import java.io.Serializable;
import java.util.Objects;

public class SuiviId implements Serializable {
    private String num_inscription;
    private String id_matiere;

    public SuiviId() {
    }

    public SuiviId(String num_inscription, String id_matiere) {
        this.num_inscription = num_inscription;
        this.id_matiere = id_matiere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuiviId suiviId = (SuiviId) o;
        return Objects.equals(num_inscription, suiviId.num_inscription) && Objects.equals(id_matiere, suiviId.id_matiere);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num_inscription, id_matiere);
    }
}
