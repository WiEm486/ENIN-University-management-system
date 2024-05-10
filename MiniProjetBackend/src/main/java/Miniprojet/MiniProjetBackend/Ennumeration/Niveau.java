package Miniprojet.MiniProjetBackend.Ennumeration;

public enum Niveau {
    PREMIERE("1ére"), DEUXIEME("2éme"), TROISIEME("3éme");
    private String niveau;

    Niveau(String niveau) {
        this.niveau = niveau;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
}
