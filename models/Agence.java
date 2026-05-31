package models;

import java.util.ArrayList;
import java.util.List;

public class Agence {
    private String idAgence;
    private String nomAgence;
    private String adresse;
    private String telephone;
    private String ville;
    private List<PointDeVente> pointsDeVente;
    private List<Reclamation> reclamations;
    
    public Agence(String idAgence, String nomAgence, String adresse, String telephone, String ville) {
        this.idAgence = idAgence;
        this.nomAgence = nomAgence;
        this.adresse = adresse;
        this.telephone = telephone;
        this.ville = ville;
        this.pointsDeVente = new ArrayList<>();
        this.reclamations = new ArrayList<>();
    }
    
    public void ajouterPointDeVente(PointDeVente pointDeVente) {
        pointsDeVente.add(pointDeVente);
        pointDeVente.setAgence(this);
    }
    
    public List<PointDeVente> getPointsDeVente() {
        return pointsDeVente;
    }
    
    public void recevoirReclamation(Reclamation reclamation) {
        reclamations.add(reclamation);
    }
    
    public List<Reclamation> getReclamations() {
        return reclamations;
    }
    
    public String getIdAgence() { return idAgence; }
    public void setIdAgence(String idAgence) { this.idAgence = idAgence; }
    public String getNomAgence() { return nomAgence; }
    public void setNomAgence(String nomAgence) { this.nomAgence = nomAgence; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }
    
    @Override
    public String toString() {
        return String.format("Agence: %s - %s, %s", nomAgence, ville, telephone);
    }
}