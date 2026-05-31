package models;

import enums.ClasseVoyage;

public class Siege {
    private int numeroSiege;
    private int numeroWagon;
    private ClasseVoyage classe;
    private boolean estOccupe;
    
    public Siege(int numeroSiege, int numeroWagon, ClasseVoyage classe) {
        this.numeroSiege = numeroSiege;
        this.numeroWagon = numeroWagon;
        this.classe = classe;
        this.estOccupe = false;
    }
    
    public int getNumeroSiege() { return numeroSiege; }
    public void setNumeroSiege(int numeroSiege) { this.numeroSiege = numeroSiege; }
    public int getNumeroWagon() { return numeroWagon; }
    public void setNumeroWagon(int numeroWagon) { this.numeroWagon = numeroWagon; }
    public ClasseVoyage getClasse() { return classe; }
    public void setClasse(ClasseVoyage classe) { this.classe = classe; }
    public boolean isEstOccupe() { return estOccupe; }
    public void setEstOccupe(boolean estOccupe) { this.estOccupe = estOccupe; }
    
    public void reserver() {
        if (!estOccupe) {
            this.estOccupe = true;
        } else {
            throw new IllegalStateException("Ce siège est déjà occupé");
        }
    }
    
    public void liberer() {
        this.estOccupe = false;
    }
    
    @Override
    public String toString() {
        return String.format("Wagon %d, Siège %d (%s) - %s", 
            numeroWagon, numeroSiege, classe.getLibelle(), 
            estOccupe ? "Occupé" : "Libre");
    }
}