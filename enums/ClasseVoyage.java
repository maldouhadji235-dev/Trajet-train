package enums;

public enum ClasseVoyage {
    PREMIERE("1ère Classe", 1.5),
    SECONDE("2e Classe", 1.0),
    WAGON_LIT("Wagon Lit", 2.5);
    
    private String libelle;
    private double coefficientPrix;
    
    ClasseVoyage(String libelle, double coefficientPrix) {
        this.libelle = libelle;
        this.coefficientPrix = coefficientPrix;
    }
    
    public String getLibelle() { return libelle; }
    public double getCoefficientPrix() { return coefficientPrix; }
}