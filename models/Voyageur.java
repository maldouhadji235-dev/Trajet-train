package models;

import java.util.ArrayList;
import java.util.List;

public class Voyageur {
    private String idVoyageur;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private List<Reservation> reservations;
    
    public Voyageur(String idVoyageur, String nom, String prenom, String email, String telephone) {
        this.idVoyageur = idVoyageur;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.reservations = new ArrayList<>();
    }
    
    public void ajouterReservation(Reservation reservation) {
        reservations.add(reservation);
        reservation.setVoyageur(this);
    }
    
    public List<Reservation> getReservations() {
        return reservations;
    }
    
    public String getIdVoyageur() { return idVoyageur; }
    public void setIdVoyageur(String idVoyageur) { this.idVoyageur = idVoyageur; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    
    @Override
    public String toString() {
        return String.format("Voyageur: %s %s (%s)", prenom, nom, email);
    }
}