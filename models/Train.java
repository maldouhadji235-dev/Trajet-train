package models;

import java.util.ArrayList;
import java.util.List;
import enums.ClasseVoyage;

public class Train {
    private String numeroTrain;
    private String nomTrain;
    private ClasseVoyage categorieClasse;
    private List<Arret> arrets;
    
    public Train(String numeroTrain, String nomTrain, ClasseVoyage categorieClasse) {
        this.numeroTrain = numeroTrain;
        this.nomTrain = nomTrain;
        this.categorieClasse = categorieClasse;
        this.arrets = new ArrayList<>();
    }
    
    public void ajouterArret(Arret arret, int position) {
        arret.setPositionOrdre(position);
        arret.setTrain(this);
        arrets.add(arret);
    }
    
    public List<Arret> getArrets() {
        return arrets;
    }
    
    public String getNumeroTrain() { return numeroTrain; }
    public void setNumeroTrain(String numeroTrain) { this.numeroTrain = numeroTrain; }
    public String getNomTrain() { return nomTrain; }
    public void setNomTrain(String nomTrain) { this.nomTrain = nomTrain; }
    public ClasseVoyage getCategorieClasse() { return categorieClasse; }
    public void setCategorieClasse(ClasseVoyage categorieClasse) { this.categorieClasse = categorieClasse; }
    
    @Override
    public String toString() {
        return String.format("Train %s - %s (%s)", numeroTrain, nomTrain, categorieClasse.getLibelle());
    }
}