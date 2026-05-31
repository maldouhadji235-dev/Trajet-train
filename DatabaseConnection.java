

import java.sql.*;

public class DatabaseConnection {
    private static Connection connection = null;
    
    // Configuration XAMPP par défaut
    private static final String URL = "jdbc:mysql://localhost:3306/train_reservation?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "";  // XAMPP: mot de passe vide par défaut
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✓ Driver MySQL chargé avec succès");
        } catch (ClassNotFoundException e) {
            System.err.println("✗ Driver MySQL non trouvé ! Vérifiez le fichier JAR dans lib/");
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✓ Connecté à MySQL (XAMPP)");
            } catch (SQLException e) {
                System.err.println("✗ Erreur de connexion à MySQL");
                System.err.println("  → Vérifiez que MySQL est démarré dans XAMPP");
                System.err.println("  → Vérifiez que la base de données 'train_reservation' existe");
                throw e;
            }
        }
        return connection;
    }
    
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("✓ Déconnexion de MySQL");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Tester la connexion
    public static boolean testConnection() {
        try {
            Connection conn = getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            System.out.println("✓ Base de données: " + metaData.getDatabaseProductName());
            System.out.println("✓ Version: " + metaData.getDatabaseProductVersion());
            System.out.println("✓ Connecté avec succès à XAMPP MySQL");
            return true;
        } catch (SQLException e) {
            System.err.println("✗ Échec de connexion: " + e.getMessage());
            return false;
        }
    }
}