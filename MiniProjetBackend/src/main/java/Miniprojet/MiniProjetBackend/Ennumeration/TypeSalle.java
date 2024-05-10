package Miniprojet.MiniProjetBackend.Ennumeration;

public enum TypeSalle {
    AMPHI("Amphi"),TPINFO("Tp_Inforamtique"),TPMECANIQUE("Tp_Mecanique"),TPELECTRIQUE("Tp_Electrique"),
    TPGENIECIVIL("Tp_Génie_Civil"),COURS("Salle_de_Cours");
    public String TypeSalle;

    TypeSalle(String typeSalle) {
        TypeSalle = typeSalle;
    }

    public String getTypeSalle() {
        return TypeSalle;
    }

    public void setTypeSalle(String typeSalle) {
        TypeSalle = typeSalle;
    }
}
