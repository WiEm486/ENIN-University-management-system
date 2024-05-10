package Miniprojet.MiniProjetBackend.Ennumeration;

import java.util.HashMap;
import java.util.Map;

public enum StatusDemande {
    ENCOURS("en cours"),
    ACCEPTE("accepté"),
    REFUSE("refusé");
    private String valeur;

    StatusDemande(String valeur) {
        this.valeur =valeur;

    }

    private static final Map<String, StatusDemande> STRING_Status_MAP = new HashMap<>();
    static {
        for (StatusDemande status : values()) {
            STRING_Status_MAP.put(status.valeur, status);
        }
    }
    public String getStringValue() {
        return valeur;
    }

    public static StatusDemande fromString(String stringValue) {
        return STRING_Status_MAP.get(stringValue);
    }
}
