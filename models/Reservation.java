package models;

import enums.ClasseVoyage;
import enums.StatutReservation;
import java.time.LocalDateTime;

public class Reservation {
    private String idReservation;
    private LocalDateTime dateReservation;
    private StatutReservation statut;
    private double prixTotal;
    private Voyageur voyageur;
    private Train train;
    private Arret arretDepart;
    private Arret arretArrivee;
    private Siege siege;
    private ClasseVoyage classeChoisie;
    
    public Reservation(String idReservation, Voyageur voyageur, Train train, 
                       Arret arretDepart, Arret arretArrivee, Siege siege, 
                       ClasseVoyage classeChoisie) {
        this.idReservation = idReservation;
        this.dateReservation = LocalDateTime.now();
        this.statut = StatutReservation.EN_ATTENTE;
        this.voyageur = voyageur;
        this.train = train;
        this.arretDepart = arretDepart;
        this.arretArrivee = arretArrivee;
        this.siege = siege;
        this.classeChoisie = classeChoisie;
        this.prixTotal = calculerPrix();
    }
    
    private double calculerPrix() {
        double prixBase = 5000.0;
        int nbArrets = Math.abs(arretArrivee.getPositionOrdre() - arretDepart.getPositionOrdre());
        return prixBase * nbArrets * classeChoisie.getCoefficientPrix();
    }
    
    public void annuler() {
        if (statut == StatutReservation.CONFIRMEE || statut == StatutReservation.EN_ATTENTE) {
            this.statut = StatutReservation.ANNULEE;
            if (siege != null) {
                siege.liberer();
            }
        } else {
            throw new IllegalStateException("Cette réservation ne peut pas être annulée");
        }
    }
    
    public void confirmer() {
        if (statut == StatutReservation.EN_ATTENTE) {
            this.statut = StatutReservation.CONFIRMEE;
            if (siege != null) {
                siege.reserver();
            }
        }
    }
    
    public String getIdReservation() { return idReservation; }
    public void setIdReservation(String idReservation) { this.idReservation = idReservation; }
    public LocalDateTime getDateReservation() { return dateReservation; }
    public void setDateReservation(LocalDateTime dateReservation) { this.dateReservation = dateReservation; }
    public StatutReservation getStatut() { return statut; }
    public void setStatut(StatutReservation statut) { this.statut = statut; }
    public double getPrixTotal() { return prixTotal; }
    public void setPrixTotal(double prixTotal) { this.prixTotal = prixTotal; }
    public Voyageur getVoyageur() { return voyageur; }
    public void setVoyageur(Voyageur voyageur) { this.voyageur = voyageur; }
    public Train getTrain() { return train; }
    public void setTrain(Train train) { this.train = train; }
    public Arret getArretDepart() { return arretDepart; }
    public void setArretDepart(Arret arretDepart) { this.arretDepart = arretDepart; }
    public Arret getArretArrivee() { return arretArrivee; }
    public void setArretArrivee(Arret arretArrivee) { this.arretArrivee = arretArrivee; }
    public Siege getSiege() { return siege; }
    public void setSiege(Siege siege) { this.siege = siege; }
    public ClasseVoyage getClasseChoisie() { return classeChoisie; }
    public void setClasseChoisie(ClasseVoyage classeChoisie) { this.classeChoisie = classeChoisie; }
    
    @Override
    public String toString() {
        return String.format("Réservation %s - %s → %s - Prix: %.2f FCFA - Statut: %s", 
            idReservation, arretDepart.getNom(), arretArrivee.getNom(), prixTotal, statut);
    }
}