package Miniprojet.MiniProjetBackend.Ennumeration;

public enum TypeSeance {
    Cours("C"),Td("Td"),Tp("Tp");
    public String regime;

    TypeSeance(String regime) {
        this.regime = regime;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }
}
