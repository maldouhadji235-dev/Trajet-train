package models;

import java.time.LocalDateTime;
import enums.StatutTicket;

public class Ticket {
    private String numeroTicket;
    private LocalDateTime dateVoyage;
    private double prix;
    private StatutTicket statutTicket;
    private Reservation reservation;
    private Siege siege;
    
    public Ticket(String numeroTicket, LocalDateTime dateVoyage, double prix, 
                  Reservation reservation, Siege siege) {
        this.numeroTicket = numeroTicket;
        this.dateVoyage = dateVoyage;
        this.prix = prix;
        this.statutTicket = StatutTicket.VALIDE;
        this.reservation = reservation;
        this.siege = siege;
    }
    
    public void valider() {
        if (statutTicket == StatutTicket.VALIDE) {
            this.statutTicket = StatutTicket.UTILISE;
        }
    }
    
    public void rembourser() {
        if (statutTicket == StatutTicket.VALIDE) {
            this.statutTicket = StatutTicket.REMBOURSE;
        } else {
            throw new IllegalStateException("Ce ticket ne peut pas être remboursé");
        }
    }
    
    public String getNumeroTicket() { return numeroTicket; }
    public void setNumeroTicket(String numeroTicket) { this.numeroTicket = numeroTicket; }
    public LocalDateTime getDateVoyage() { return dateVoyage; }
    public void setDateVoyage(LocalDateTime dateVoyage) { this.dateVoyage = dateVoyage; }
    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
    public StatutTicket getStatutTicket() { return statutTicket; }
    public void setStatutTicket(StatutTicket statutTicket) { this.statutTicket = statutTicket; }
    public Reservation getReservation() { return reservation; }
    public void setReservation(Reservation reservation) { this.reservation = reservation; }
    public Siege getSiege() { return siege; }
    public void setSiege(Siege siege) { this.siege = siege; }
    
    @Override
    public String toString() {
        return String.format("Ticket %s - Prix: %.2f FCFA - Statut: %s - %s", 
            numeroTicket, prix, statutTicket, siege);
    }
}