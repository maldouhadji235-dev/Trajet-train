package models;

import java.time.LocalDateTime;
import enums.StatutReclamation;
import enums.TypeReclamation;

public class Reclamation {
    private String idReclamation;
    private LocalDateTime dateReclamation;
    private String description;
    private StatutReclamation statut;
    private TypeReclamation type;
    private Voyageur voyageur;
    private PointDeVente pointDeVente;
    
    public Reclamation(String idReclamation, String description, TypeReclamation type, 
                       Voyageur voyageur, PointDeVente pointDeVente) {
        this.idReclamation = idReclamation;
        this.dateReclamation = LocalDateTime.now();
        this.description = description;
        this.statut = StatutReclamation.EN_ATTENTE;
        this.type = type;
        this.voyageur = voyageur;
        this.pointDeVente = pointDeVente;
    }
    
    public void traiter() {
        this.statut = StatutReclamation.TRAITEE;
    }
    
    public String getIdReclamation() { return idReclamation; }
    public void setIdReclamation(String idReclamation) { this.idReclamation = idReclamation; }
    public LocalDateTime getDateReclamation() { return dateReclamation; }
    public void setDateReclamation(LocalDateTime dateReclamation) { this.dateReclamation = dateReclamation; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public StatutReclamation getStatut() { return statut; }
    public void setStatut(StatutReclamation statut) { this.statut = statut; }
    public TypeReclamation getType() { return type; }
    public void setType(TypeReclamation type) { this.type = type; }
    public Voyageur getVoyageur() { return voyageur; }
    public void setVoyageur(Voyageur voyageur) { this.voyageur = voyageur; }
    public PointDeVente getPointDeVente() { return pointDeVente; }
    public void setPointDeVente(PointDeVente pointDeVente) { this.pointDeVente = pointDeVente; }
    
    @Override
    public String toString() {
        String desc = description.length() > 50 ? description.substring(0, 47) + "..." : description;
        return String.format("Réclamation %s - %s - Statut: %s", 
            idReclamation, desc, statut);
    }
}