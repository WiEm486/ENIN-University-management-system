package Miniprojet.MiniProjetBackend.Ennumeration;

import java.util.HashMap;
import java.util.Map;

public enum StatusActualite {
    Publie("publié"),
    Brouillon("brouillon"),
    Archive("archivé"),
    Supprime("supprimé");
    private String valeur;

    StatusActualite(String valeur) {
        this.valeur =valeur;

    }

    private static final Map<String, StatusActualite> STRING_Status_MAP = new HashMap<>();
    static {
        for (StatusActualite status : values()) {
            STRING_Status_MAP.put(status.valeur, status);
        }
    }
    public String getStringValue() {
        return valeur;
    }

    public static StatusActualite fromString(String stringValue) {
        return STRING_Status_MAP.get(stringValue);
    }
}
