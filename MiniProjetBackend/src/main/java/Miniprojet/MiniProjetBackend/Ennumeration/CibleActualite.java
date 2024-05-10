package Miniprojet.MiniProjetBackend.Ennumeration;

import java.util.HashMap;
import java.util.Map;

public enum CibleActualite {
    Etudiant("etudiant"),
    Enseignant("enseignant");

    private String valeur;

    CibleActualite(String valeur) {
        this.valeur =valeur;

    }

    private static final Map<String, CibleActualite> STRING_cible_MAP = new HashMap<>();
    static {
        for (CibleActualite cible : values()) {
            STRING_cible_MAP.put(cible.valeur, cible);
        }
    }
    public String getStringValue() {
        return valeur;
    }

    public static CibleActualite fromString(String stringValue) {
        return STRING_cible_MAP.get(stringValue);
    }

}
