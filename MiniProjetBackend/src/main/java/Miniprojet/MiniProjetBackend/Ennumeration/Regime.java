package Miniprojet.MiniProjetBackend.Ennumeration;

public enum Regime {
    QA("Qa"),QB("Qb"),H("H");
    public String regime;

    Regime(String regime) {
        this.regime = regime;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }
}
