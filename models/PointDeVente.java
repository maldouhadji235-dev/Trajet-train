package models;

import java.util.ArrayList;
import java.util.List;

public class PointDeVente {
    private String idPointDeVente;
    private String nomPointVente;
    private String adresse;
    private Agence agence;
    private List<Ticket> ticketsVendus;
    private List<Reclamation> reclamationsRecues;
    
    public PointDeVente(String idPointDeVente, String nomPointVente, String adresse) {
        this.idPointDeVente = idPointDeVente;
        this.nomPointVente = nomPointVente;
        this.adresse = adresse;
        this.ticketsVendus = new ArrayList<>();
        this.reclamationsRecues = new ArrayList<>();
    }
    
    public Ticket vendreTicket(Reservation reservation) {
        Ticket ticket = new Ticket(
            "TKT" + System.currentTimeMillis(),
            reservation.getDateReservation(),
            reservation.getPrixTotal(),
            reservation,
            reservation.getSiege()
        );
        ticketsVendus.add(ticket);
        return ticket;
    }
    
    public void recevoirReclamation(Reclamation reclamation) {
        reclamationsRecues.add(reclamation);
        if (agence != null) {
            agence.recevoirReclamation(reclamation);
        }
    }
    
    public void traiterReclamation(Reclamation reclamation) {
        reclamation.traiter();
    }
    
    public String getIdPointDeVente() { return idPointDeVente; }
    public void setIdPointDeVente(String idPointDeVente) { this.idPointDeVente = idPointDeVente; }
    public String getNomPointVente() { return nomPointVente; }
    public void setNomPointVente(String nomPointVente) { this.nomPointVente = nomPointVente; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public Agence getAgence() { return agence; }
    public void setAgence(Agence agence) { this.agence = agence; }
    public List<Ticket> getTicketsVendus() { return ticketsVendus; }
    public List<Reclamation> getReclamationsRecues() { return reclamationsRecues; }
    
    @Override
    public String toString() {
        return String.format("Point de Vente: %s - %s", nomPointVente, adresse);
    }
}