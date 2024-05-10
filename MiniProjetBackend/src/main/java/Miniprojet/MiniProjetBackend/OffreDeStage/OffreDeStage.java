package Miniprojet.MiniProjetBackend.OffreDeStage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.awt.*;
import java.util.Date;

@RequiredArgsConstructor
@Data
@Entity
public class OffreDeStage {
    @Id
    @GeneratedValue(generator = "offre-generator")
    @GenericGenerator(name = "offre-generator",
            parameters = @Parameter(name = "prefix", value = "Offre"),
            strategy = "Miniprojet.MiniProjetBackend.MyGenerator")
    private String id_Offre;
    private Date date_deb;
    private Date date_fin;
    private String entrepris;
    private String contact;
    private String post;
    private TextArea description;
}
