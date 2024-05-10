package Miniprojet.MiniProjetBackend.Ennumeration;

import java.util.HashMap;
import java.util.Map;

public enum TypeActualite {
    Annonce("annonce"),
    EVENEMENT("évènement"),
    BOURCE("bourse");
    private String valeur;

    TypeActualite(String valeur) {
        this.valeur =valeur;

    }

    private static final Map<String, TypeActualite> STRING_Type_MAP = new HashMap<>();
    static {
        for (TypeActualite type : values()) {
            STRING_Type_MAP.put(type.valeur, type);
        }
    }
    public String getStringValue() {
        return valeur;
    }

    public static TypeActualite fromString(String stringValue) {
        return STRING_Type_MAP.get(stringValue);
    }
}
