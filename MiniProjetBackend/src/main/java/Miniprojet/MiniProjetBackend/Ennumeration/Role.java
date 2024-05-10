package Miniprojet.MiniProjetBackend.Ennumeration;

import java.util.HashMap;
import java.util.Map;

public enum Role {

    ETUDIANT("Etudiant"),
    ENSEIGNANT("Enseignant"),
    CHEF_DEPARTEMENT("ChefDepartement"),
    ADMIN_ETUDIANT("AdminEtudiant"),
    ADMIN_SCOLARITE("AdminScolaite"),
    SUPER_ADMIN("SuperAdmin");

    private final String valeur;

    Role(String valeur) {
        this.valeur =valeur;

    }

    private static final Map<String, Role> STRING_ROLE_MAP = new HashMap<>();
    static {
        for (Role role : values()) {
            STRING_ROLE_MAP.put(role.valeur, role);
        }
    }
    public String getStringValue() {
        return valeur;
    }

    public static Role fromString(String stringValue) {
        return STRING_ROLE_MAP.get(stringValue);
    }




}
