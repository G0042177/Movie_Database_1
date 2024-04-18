package ie.atu;
import java.sql.*;

public class Account {
    public static void updateName(Connection conn,String updatedName,String username) {
        try {
            // Insert a new record into the "users" table
            PreparedStatement stmt = conn.prepareStatement("UPDATE users SET name = ? WHERE username = ?");
            stmt.setString(1, updatedName);
            stmt.setString(2, username);
            stmt.executeUpdate();


            System.out.println("Updated Name...");
        } catch (SQLException ex) {

            System.out.println("Failed to update name");
            ex.printStackTrace();
        }


    }
    public static void updateUsername(Connection conn,String updatedUsername,String username) {
        try {
            // Insert a new record into the "users" table
            PreparedStatement stmt = conn.prepareStatement("UPDATE users SET username = ? WHERE username = ?");
            stmt.setString(1, updatedUsername);
            stmt.setString(2, username);
            stmt.executeUpdate();


            System.out.println("Updated Username...");
        } catch (SQLException ex) {

            System.out.println("Failed to update username");
            ex.printStackTrace();
        }
    }

    public static void updatePassword(Connection conn,String updatedPassword,String username) {
        try {
            // Insert a new record into the "users" table
            PreparedStatement stmt = conn.prepareStatement("UPDATE users SET password = ? WHERE username = ?");
            stmt.setString(1, updatedPassword);
            stmt.setString(2, username);
            stmt.executeUpdate();


            System.out.println("Updated Password...");
        } catch (SQLException ex) {

            System.out.println("Failed to update Password");
            ex.printStackTrace();
        }
    }
    public static void updateEmail(Connection conn,String updatedEmail,String username) {
        try {
            // Insert a new record into the "users" table
            PreparedStatement stmt = conn.prepareStatement("UPDATE users SET email = ? WHERE username = ?");
            stmt.setString(1, updatedEmail);
            stmt.setString(2, username);
            stmt.executeUpdate();


            System.out.println("Updated Email...");
        } catch (SQLException ex) {

            System.out.println("Failed to update Email");
            ex.printStackTrace();
        }
    }

    public static void deleteAccount(Connection conn,String username) {
        try {

            PreparedStatement UserId = conn.prepareStatement("SELECT user_id FROM users WHERE username = ?");
            UserId.setString(1, username);
            ResultSet userIdResult = UserId.executeQuery();

            if (userIdResult.next()) {
                int userId = userIdResult.getInt("user_id");

                // Delete the user_id from all tables one at tiem
                PreparedStatement deleteLiked = conn.prepareStatement("DELETE FROM favorite_movies WHERE user_id = ?");
                deleteLiked.setInt(1, userId);
                deleteLiked.executeUpdate();

                PreparedStatement deletePlaylist = conn.prepareStatement("DELETE FROM watchlist WHERE user_id = ?");
                deletePlaylist.setInt(1, userId);
                deletePlaylist.executeUpdate();

                PreparedStatement deleteAccountStmt = conn.prepareStatement("DELETE FROM users WHERE username = ?");
                deleteAccountStmt.setString(1, username);
                deleteAccountStmt.executeUpdate();

                System.out.println("Successfully Deleted Account...");
            }
        } catch (SQLException ex) {
            // Print an error message if deletion fails
            System.out.println("Failed to delete account. ");
            ex.printStackTrace();
        }
    }
}
