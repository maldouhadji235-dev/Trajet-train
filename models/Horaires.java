package models;

import java.time.LocalDateTime;
import java.time.Duration;

public class Horaires {
    private LocalDateTime heureDepart;
    private LocalDateTime heureArrivee;
    private LocalDateTime date;
    
    public Horaires(LocalDateTime heureDepart, LocalDateTime heureArrivee, LocalDateTime date) {
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
        this.date = date;
    }
    
    public long getDuree() {
        return Duration.between(heureDepart, heureArrivee).toMinutes();
    }
    
    public LocalDateTime getHeureDepart() { return heureDepart; }
    public void setHeureDepart(LocalDateTime heureDepart) { this.heureDepart = heureDepart; }
    public LocalDateTime getHeureArrivee() { return heureArrivee; }
    public void setHeureArrivee(LocalDateTime heureArrivee) { this.heureArrivee = heureArrivee; }
    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
    
    @Override
    public String toString() {
        return String.format("Départ: %s, Arrivée: %s, Durée: %d minutes", 
            heureDepart, heureArrivee, getDuree());
    }
}