package ie.atu;
import com.sun.source.tree.CaseTree;
import ie.atu.Account;
import ie.atu.pool.DatabaseUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Login {
    public static void main(String[] args) throws SQLException {
        String continuing = "y";
        int y = 0;
        int x = 0;
        int logout = 0;
// Connect to the database
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase", "root", "user");
        Scanner scanner = new Scanner(System.in);
        char log;
        System.out.println("Would you like to: Login or Sign-up? L || S:");
        log = scanner.nextLine().charAt(0);

        if (log == 'S' || log == 's') {
            signUp(conn, scanner);
        } else if (log == 'L' || log == 'l') {
            try {
// Prompt the user to input data
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                System.out.println("Enter password:");
                String password = scanner.nextLine();

                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet resultSet = stmt.executeQuery();
                if (resultSet.next()) {
                    System.out.println("Login successful .\n");
                    x = 1;
                } else {
                    System.out.println("Invalid username or password.");
                }
                if (x == 1) {
                    while (continuing.equalsIgnoreCase("y")) {
                        System.out.println("Hello, \n What would you like to do " + username);
                        String[] menu = Menu_display.displayMenu();
                        for (String menuHeadings : menu) {
                            System.out.println(menuHeadings);
                        }
                        String choice = scanner.nextLine();
                        switch (choice) {
                            case "M":
                                System.out.println("Main Menu");
                                Main_Menu main_menu = new Main_Menu();
                                main_menu.showMovies();
                                System.out.println();
                                main_menu.showGenres();
                                break;
                            case "S":
                                System.out.println("Search some Movies");
                                System.out.println("Which movie would you like to watch? ");
                                String userSearch = scanner.nextLine();
                                Movie_Search_Menu searchMenu = new Movie_Search_Menu();
                                ArrayList<String> results = searchMenu.searchMovie(conn, scanner, userSearch);
                                if (results.size() == 0) {
                                    System.out.println("No results found\n");
                                } else {
                                    System.out.println("Favourites:");
                                    for (String result : results) {
                                        System.out.println(result);
                                    }
                                }
                                break;
                            case "W":
                                System.out.println("Your Watchlist");
                                System.out.println("Your Favourites --> f | Your Watchlist --> w");
                                int option = scanner.nextInt();
                                scanner.nextLine();
                                if (option == 1) {
                                    Favourites.showFavorites(username);
                                } else if (option == 2) {
                                    Watchlist.showWatchlist(username, scanner);
                                } else {
                                    System.out.println("Invalid Entry, Try again");
                                }
                                break;
                            case "A":
                                System.out.println("Account");
                                System.out.println("Update Name (1) | Update Username (2) | Update Passwords (3) | Update Email (4) | Update Subscription (5) | Back to menu (6) | DELETE ACCOUNT (7)");//choose to see playlists and liked songs
                                int setting = scanner.nextInt();
                                scanner.nextLine();
                                switch (setting) {
                                    case 1:
                                        System.out.println("Change name");
                                        System.out.println("Enter your new name:");
                                        String updatedName = scanner.nextLine();
                                        Account.updateName(conn, updatedName, username);
                                        break;
                                    case 2:
                                        System.out.println("Change username");
                                        System.out.println("Enter your new username:");
                                        String updatedUsername = scanner.nextLine();
                                        Account.updateUsername(conn, updatedUsername, username);
                                        break;
                                    case 3:
                                        System.out.println("Change Password");
                                        System.out.println("Enter your new Password:");
                                        String updatedPassword = scanner.nextLine();
                                        Account.updatePassword(conn, updatedPassword, username);
                                        break;
                                    case 4:
                                        System.out.println("Change Email");
                                        System.out.println("Enter your new Email:");
                                        String updatedEmail = scanner.nextLine();
                                        Account.updateEmail(conn, updatedEmail, username);
                                        break;
                                    case 5:
                                        System.out.println("Back to menu");
                                        break;
                                    case 6:
                                        System.out.println("Delete Account!");
                                        Account.deleteAccount(conn, username);
                                        break;
                                    default:
                                        System.out.println("Invalid option");
                                        break;
                                }
                                break;
                            case "L":
                                System.out.println("Logging out...");
                                return;
                            default:
                                System.out.println("INVALID ENTRY");
                                break;
                        }
                        System.out.print("Continue? (yes or no): ");
                        continuing = scanner.nextLine();
                        System.out.println();
                    }
                }
            } catch (SQLException ex) {
                System.out.println("Login failed.");
                ex.printStackTrace();
            }
        }
//if a user does not enter L or S when asked
        else {
            System.out.println("Invalid option --> 'L' for Log-in, or 'S' for Sign-up.");
        }
    }

    //increments the user_id for signing up
//this way it creates another user after the last one in the database and doesn't start at id=0
    private static int getLastInsertId(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
// Retrieve the maximum value of the user_id column from the users table
            ResultSet rs = stmt.executeQuery("SELECT MAX(user_id) FROM user");
            rs.next();
            int maxId = rs.getInt(1);
// Increment the maximum value by 1 to get the next available user_id
            return maxId + 1;
        }
    }

    public static void signUp(Connection conn, Scanner scanner) {
        ArrayList<String> details = new ArrayList<String>();
        try {
// Prompt the user to input data
            System.out.println("Enter full name:");
            String name = scanner.nextLine();
            details.add("Name:" + name);
            System.out.println("Enter username:");
            String username = scanner.nextLine();
            details.add("Username:" + username);
            System.out.println("Enter email:");
            String email = scanner.nextLine();
            details.add("Email:" + email);
            System.out.println("Enter DOB XXXX-XX-XX:");
            String dob = scanner.nextLine();
            details.add("DOB:" + dob);
            System.out.println("Enter gender, male, female or other");
            String gender = scanner.nextLine();
            details.add("Gender:" + gender);
            System.out.println("Enter country:");
            String country = scanner.nextLine();
            details.add("Country:" + country);
            System.out.println("Create a password");
            String password = scanner.nextLine();
            details.add("Password:" + password);

            for (String detail : details) {
                System.out.println(detail);
            }
// Insert a new record into the "users" table
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO user(user_id,name, email, dob, username, password, gender, country) VALUES (?,?,?,?,?,?,?,?)");
            stmt.setInt(1, getLastInsertId(conn));
            stmt.setString(2, name);
            stmt.setString(3, email);
            stmt.setString(4, dob);
            stmt.setString(5, username);
            stmt.setString(6, password);
            stmt.setString(7, gender);
            stmt.setString(8, country);
            stmt.executeUpdate();
            System.out.println("We're working on it...");
            System.out.println("Congrats, User createdm");
        } catch (SQLException ex) {
            System.out.println("Failed to create user!");
            ex.printStackTrace();
        }
    }
}

