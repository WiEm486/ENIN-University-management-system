package Miniprojet.MiniProjetBackend.Ennumeration;

import java.util.HashMap;
import java.util.Map;

public enum Jour {
    LUNDI("lundi"),
    MARDI("mardi"),
    MERCREDI("mercredi"),
    JEUDI("jeudi"),
    VENDREDI("vendredi"),
    SAMEDI("samedi"),
    DIMENCHE("dimenche");
    private final String valeur;

    Jour(String valeur) {
        this.valeur =valeur;

    }

    private static final Map<String, Jour> STRING_Jour_MAP = new HashMap<>();
    static {
        for (Jour jour : values()) {
            STRING_Jour_MAP.put(jour.valeur, jour);
        }
    }
    public String getStringValue() {
        return valeur;
    }

    public static Jour fromString(String stringValue) {
        return STRING_Jour_MAP.get(stringValue);
    }
}
