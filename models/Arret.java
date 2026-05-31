package models;

public class Arret {
    private String nom;
    private Train train;
    private int positionOrdre;
    private Horaires horaires;
    
    public Arret(String nom, int positionOrdre, Horaires horaires) {
        this.nom = nom;
        this.positionOrdre = positionOrdre;
        this.horaires = horaires;
    }
    
    public Arret(String nom, int positionOrdre) {
        this.nom = nom;
        this.positionOrdre = positionOrdre;
    }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public Train getTrain() { return train; }
    public void setTrain(Train train) { this.train = train; }
    public int getPositionOrdre() { return positionOrdre; }
    public void setPositionOrdre(int positionOrdre) { this.positionOrdre = positionOrdre; }
    public Horaires getHoraires() { return horaires; }
    public void setHoraires(Horaires horaires) { this.horaires = horaires; }
    
    @Override
    public String toString() {
        if (horaires != null) {
            return String.format("Arrêt: %s (Position %d) - %s", nom, positionOrdre, horaires);
        }
        return String.format("Arrêt: %s (Position %d)", nom, positionOrdre);
    }
}