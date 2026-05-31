import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import models.*;
import enums.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║     SYSTÈME DE RÉSERVATION DE TRAIN N'DJAMÉNA - NGAOUNDÉRÉ     ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        try {
            // 1. CRÉATION DU TRAIN
            System.out.println("【1】 CRÉATION DU TRAIN");
            System.out.println("----------------------------------------");
            Train trainExpress = new Train("TN001", "Express Tchad-Cameroun", ClasseVoyage.PREMIERE);
            
            // 2. CRÉATION DES ARRÊTS
            LocalDateTime maintenant = LocalDateTime.now();
            
            Arret arretNgaoundere = new Arret("Ngaoundéré (Départ)", 0, 
                new Horaires(maintenant, maintenant.plusMinutes(30), maintenant));
            Arret arretMbe = new Arret("Mbe", 1, 
                new Horaires(maintenant.plusHours(1), maintenant.plusHours(1).plusMinutes(15), maintenant));
            Arret arretGouna = new Arret("Gouna", 2, 
                new Horaires(maintenant.plusHours(2), maintenant.plusHours(2).plusMinutes(15), maintenant));
            Arret arretRabinga = new Arret("Rabinga", 3, 
                new Horaires(maintenant.plusHours(3), maintenant.plusHours(3).plusMinutes(15), maintenant));
            Arret arretGaroua = new Arret("Garoua", 4, 
                new Horaires(maintenant.plusHours(4), maintenant.plusHours(4).plusMinutes(30), maintenant));
            Arret arretGuider = new Arret("Guider Moutourwa", 5, 
                new Horaires(maintenant.plusHours(5), maintenant.plusHours(5).plusMinutes(15), maintenant));
            Arret arretMaroua = new Arret("Maroua", 6, 
                new Horaires(maintenant.plusHours(6), maintenant.plusHours(6).plusMinutes(15), maintenant));
            Arret arretKousserie = new Arret("Koussérie", 7, 
                new Horaires(maintenant.plusHours(7), maintenant.plusHours(7).plusMinutes(30), maintenant));
            Arret arretNdjamenna = new Arret("N'Djaména (Arrivée)", 8, 
                new Horaires(maintenant.plusHours(8), maintenant.plusHours(8).plusMinutes(30), maintenant));
            
            trainExpress.ajouterArret(arretNgaoundere, 0);
            trainExpress.ajouterArret(arretMbe, 1);
            trainExpress.ajouterArret(arretGouna, 2);
            trainExpress.ajouterArret(arretRabinga, 3);
            trainExpress.ajouterArret(arretGaroua, 4);
            trainExpress.ajouterArret(arretGuider, 5);
            trainExpress.ajouterArret(arretMaroua, 6);
            trainExpress.ajouterArret(arretKousserie, 7);
            trainExpress.ajouterArret(arretNdjamenna, 8);
            
            System.out.println(trainExpress);
            System.out.println("\nListe des arrêts du trajet:");
            System.out.println("┌─────┬─────────────────────┬────────────────────────────┐");
            System.out.println("│ N°  │ Arrêt                │ Horaire                    │");
            System.out.println("├─────┼─────────────────────┼────────────────────────────┤");
            for (Arret arret : trainExpress.getArrets()) {
                String horaire = "Départ: " + arret.getHoraires().getHeureDepart().format(formatter);
                System.out.printf("│ %-3d │ %-19s │ %-26s │\n", 
                    arret.getPositionOrdre(), arret.getNom(), horaire);
            }
            System.out.println("└─────┴─────────────────────┴────────────────────────────┘\n");
            
            // 3. CRÉATION DES AGENCES ET POINTS DE VENTE
            System.out.println("【2】 CRÉATION DES AGENCES ET POINTS DE VENTE");
            System.out.println("----------------------------------------");
            
            Agence agenceNgaoundere = new Agence("AG001", "Agence Centrale Ngaoundéré", 
                "Avenue de la Gare, Ngaoundéré", "222 11 22 33", "Ngaoundéré");
            Agence agenceGaroua = new Agence("AG002", "Agence Régionale Garoua", 
                "Boulevard de l'Indépendance, Garoua", "222 44 55 66", "Garoua");
            Agence agenceMaroua = new Agence("AG003", "Agence Nord Extrême", 
                "Rue des Voyageurs, Maroua", "222 77 88 99", "Maroua");
            
            PointDeVente pointVenteGare = new PointDeVente("PV001", "Point de Vente Gare SNCF", 
                "Gare Centrale, Ngaoundéré");
            PointDeVente pointVenteCentre = new PointDeVente("PV002", "Point de Vente Centre Ville", 
                "Rue Principal, Ngaoundéré");
            PointDeVente pointVenteMarche = new PointDeVente("PV003", "Point de Vente Grand Marché", 
                "Marché Central, Garoua");
            
            agenceNgaoundere.ajouterPointDeVente(pointVenteGare);
            agenceNgaoundere.ajouterPointDeVente(pointVenteCentre);
            agenceGaroua.ajouterPointDeVente(pointVenteMarche);
            
            System.out.println(agenceNgaoundere);
            System.out.println("  → Points de vente:");
            for (PointDeVente pv : agenceNgaoundere.getPointsDeVente()) {
                System.out.println("     • " + pv);
            }
            System.out.println(agenceGaroua);
            System.out.println("  → Points de vente:");
            for (PointDeVente pv : agenceGaroua.getPointsDeVente()) {
                System.out.println("     • " + pv);
            }
            System.out.println();
            
            // 4. CRÉATION DES VOYAGEURS
            System.out.println("【3】 ENREGISTREMENT DES VOYAGEURS");
            System.out.println("----------------------------------------");
            
            Voyageur voyageur1 = new Voyageur("V001", "Djibril", "Mohamed", 
                "mohamed.djibril@email.com", "+237 698 12 34 56");
            Voyageur voyageur2 = new Voyageur("V002", "Ali", "Fatima", 
                "fatima.ali@email.com", "+237 699 98 76 54");
            Voyageur voyageur3 = new Voyageur("V003", "Bello", "Hamadou", 
                "hamadou.bello@email.com", "+235 601 23 45 67");
            
            System.out.println("✓ " + voyageur1);
            System.out.println("✓ " + voyageur2);
            System.out.println("✓ " + voyageur3);
            System.out.println();
            
            // 5. CRÉATION DES SIÈGES
            System.out.println("【4】 CONFIGURATION DES SIÈGES");
            System.out.println("----------------------------------------");
            
            Siege siege1 = new Siege(15, 1, ClasseVoyage.PREMIERE);
            Siege siege2 = new Siege(42, 2, ClasseVoyage.SECONDE);
            Siege siege3 = new Siege(8, 3, ClasseVoyage.WAGON_LIT);
            Siege siege4 = new Siege(25, 1, ClasseVoyage.PREMIERE);
            Siege siege5 = new Siege(67, 2, ClasseVoyage.SECONDE);
            
            System.out.println("✓ " + siege1);
            System.out.println("✓ " + siege2);
            System.out.println("✓ " + siege3);
            System.out.println("✓ " + siege4);
            System.out.println("✓ " + siege5);
            System.out.println();
            
            // 6. RÉSERVATIONS
            System.out.println("【5】 PROCESSUS DE RÉSERVATION");
            System.out.println("----------------------------------------");
            
            // Réservation 1: Ngaoundéré → Garoua en 1ère classe
            Reservation reservation1 = new Reservation("RES001", voyageur1, trainExpress, 
                arretNgaoundere, arretGaroua, siege1, ClasseVoyage.PREMIERE);
            voyageur1.ajouterReservation(reservation1);
            reservation1.confirmer();
            System.out.println("✓ Réservation créée: " + reservation1);
            
            // Réservation 2: Garoua → Maroua en Wagon Lit
            Reservation reservation2 = new Reservation("RES002", voyageur2, trainExpress, 
                arretGaroua, arretMaroua, siege3, ClasseVoyage.WAGON_LIT);
            voyageur2.ajouterReservation(reservation2);
            reservation2.confirmer();
            System.out.println("✓ Réservation créée: " + reservation2);
            
            // Réservation 3: Mbe → Koussérie en 2ème classe
            Reservation reservation3 = new Reservation("RES003", voyageur3, trainExpress, 
                arretMbe, arretKousserie, siege2, ClasseVoyage.SECONDE);
            voyageur3.ajouterReservation(reservation3);
            reservation3.confirmer();
            System.out.println("✓ Réservation créée: " + reservation3);
            System.out.println();
            
            // 7. VENTE DES TICKETS
            System.out.println("【6】 ÉMISSION DES TICKETS");
            System.out.println("----------------------------------------");
            
            Ticket ticket1 = pointVenteGare.vendreTicket(reservation1);
            Ticket ticket2 = pointVenteMarche.vendreTicket(reservation2);
            Ticket ticket3 = pointVenteCentre.vendreTicket(reservation3);
            
            System.out.println("✓ Ticket émis au " + pointVenteGare.getNomPointVente() + ":");
            System.out.println("     " + ticket1);
            System.out.println("✓ Ticket émis au " + pointVenteMarche.getNomPointVente() + ":");
            System.out.println("     " + ticket2);
            System.out.println("✓ Ticket émis au " + pointVenteCentre.getNomPointVente() + ":");
            System.out.println("     " + ticket3);
            System.out.println();
            
            // 8. DÉPÔT DE RÉCLAMATIONS
            System.out.println("【7】 DÉPÔT DES RÉCLAMATIONS");
            System.out.println("----------------------------------------");
            
            Reclamation reclamation1 = new Reclamation("REC001", 
                "Le wagon 1ère classe n'est pas assez climatisé et les sièges sont inconfortables", 
                TypeReclamation.PLAINTE, voyageur1, pointVenteGare);
            
            Reclamation reclamation2 = new Reclamation("REC002", 
                "J'aimerais qu'il y ait plus d'arrêts à Mbe car beaucoup de voyageurs y descendent", 
                TypeReclamation.SUGGESTION, voyageur2, pointVenteMarche);
            
            Reclamation reclamation3 = new Reclamation("REC003", 
                "Le personnel du train est très accueillant et serviable !", 
                TypeReclamation.RECLAMATION, voyageur3, pointVenteCentre);
            
            pointVenteGare.recevoirReclamation(reclamation1);
            pointVenteMarche.recevoirReclamation(reclamation2);
            pointVenteCentre.recevoirReclamation(reclamation3);
            
            System.out.println("✓ " + reclamation1);
            System.out.println("✓ " + reclamation2);
            System.out.println("✓ " + reclamation3);
            System.out.println();
            
            // 9. TRAITEMENT DES RÉCLAMATIONS
            System.out.println("【8】 TRAITEMENT DES RÉCLAMATIONS");
            System.out.println("----------------------------------------");
            
            pointVenteGare.traiterReclamation(reclamation1);
            System.out.println("✓ Réclamation REC001 traitée");
            System.out.println("  → Nouveau statut: " + reclamation1.getStatut());
            System.out.println();
            
            // 10. VALIDATION DE TICKET
            System.out.println("【9】 VALIDATION DES TICKETS (Embarquement)");
            System.out.println("----------------------------------------");
            
            ticket1.valider();
            System.out.println("✓ Ticket " + ticket1.getNumeroTicket() + " validé pour l'embarquement");
            System.out.println("  → Statut: " + ticket1.getStatutTicket());
            System.out.println();
            
            // 11. ANNULATION D'UNE RÉSERVATION
            System.out.println("【10】 ANNULATION DE RÉSERVATION");
            System.out.println("----------------------------------------");
            
            System.out.println("Avant annulation:");
            System.out.println("  → " + reservation3);
            System.out.println("  → " + siege2);
            
            reservation3.annuler();
            
            System.out.println("\nAprès annulation:");
            System.out.println("  → " + reservation3);
            System.out.println("  → " + siege2);
            System.out.println();
            
            // 12. REMBOURSEMENT
            System.out.println("【11】 REMBOURSEMENT DE TICKET");
            System.out.println("----------------------------------------");
            
            Ticket ticketAnnule = pointVenteCentre.vendreTicket(reservation3);
            System.out.println("Ticket créé pour la réservation annulée: " + ticketAnnule.getNumeroTicket());
            ticketAnnule.rembourser();
            System.out.println("✓ Ticket remboursé");
            System.out.println("  → Statut: " + ticketAnnule.getStatutTicket());
            System.out.println();
            
            // 13. STATISTIQUES FINALES
            System.out.println("╔════════════════════════════════════════════════════════════════╗");
            System.out.println("║                       STATISTIQUES FINALES                     ║");
            System.out.println("╚════════════════════════════════════════════════════════════════╝");
            System.out.println();
            
            System.out.println("📊 RÉSUMÉ DES VOYAGEURS:");
            System.out.println("   " + voyageur1.getNom() + " " + voyageur1.getPrenom() + 
                " - " + voyageur1.getReservations().size() + " réservation(s)");
            System.out.println("   " + voyageur2.getNom() + " " + voyageur2.getPrenom() + 
                " - " + voyageur2.getReservations().size() + " réservation(s)");
            System.out.println("   " + voyageur3.getNom() + " " + voyageur3.getPrenom() + 
                " - " + voyageur3.getReservations().size() + " réservation(s)");
            
            System.out.println("\n📊 TICKETS VENDUS PAR POINT DE VENTE:");
            System.out.println("   " + pointVenteGare.getNomPointVente() + 
                " - " + pointVenteGare.getTicketsVendus().size() + " ticket(s)");
            System.out.println("   " + pointVenteMarche.getNomPointVente() + 
                " - " + pointVenteMarche.getTicketsVendus().size() + " ticket(s)");
            System.out.println("   " + pointVenteCentre.getNomPointVente() + 
                " - " + pointVenteCentre.getTicketsVendus().size() + " ticket(s)");
            
            System.out.println("\n📊 RÉCLAMATIONS:");
            System.out.println("   Total reçu: 3");
            System.out.println("   • 1 plainte traitée");
            System.out.println("   • 1 suggestion en attente");
            System.out.println("   • 1 réclamation positive en attente");
            
            System.out.println("\n📊 RECETTES TOTALES:");
            double recettesTotales = ticket1.getPrix() + ticket2.getPrix() + ticket3.getPrix();
            System.out.printf("   %.2f FCFA (%.2f € environ)\n", recettesTotales, recettesTotales / 655.957);
            
            System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
            System.out.println("║                    EXÉCUTION TERMINÉE AVEC SUCCÈS             ║");
            System.out.println("╚════════════════════════════════════════════════════════════════╝");
            
        } catch (Exception e) {
            System.err.println("❌ Erreur: " + e.getMessage());
            e.printStackTrace();
        }
    }
}