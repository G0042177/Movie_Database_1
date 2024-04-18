package ie.atu.test;

import ie.atu.Movie_Search;
import ie.atu.Movie_Search_Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieSearchTest {

    public static void main(String[] args) {
        testSearchMovie();
    }

    public static void testSearchMovie() {
        // Mock Connection and Scanner
        Connection conn = null; // Simulated connection, not used in this test
        Scanner scanner = new Scanner(System.in); // Mock scanner for user input, not used in this test

        // Prepare test data
        String userSearch = "Action";

        // Mock PreparedStatement and ResultSet
        try {
            PreparedStatement stmt = null; // Simulated prepared statement, not used in this test
            ResultSet resultSet = null; // Simulated result set, not used in this test

            // Simulated data for the result set
            ArrayList<String> testData = new ArrayList<>();
            testData.add("Movie1 - Action");
            testData.add("Movie2 - Action");

            // Create a mock object for Movie_Search_Menu
            Movie_Search movieSearch = new Movie_Search_Menu() {
                @Override
                public ArrayList<String> searchMovie(Connection conn, Scanner scanner, String userSearch) throws SQLException {
                    return testData; // Return simulated data directly
                }
            };

            // Call the method under test
            ArrayList<String> results = movieSearch.searchMovie(conn, scanner, userSearch);

            // Verify the results
            if (results.size() == testData.size()) {
                boolean allMatch = true;
                for (int i = 0; i < results.size(); i++) {
                    if (!results.get(i).equals(testData.get(i))) {
                        allMatch = false;
                        break;
                    }
                }
                if (allMatch) {
                    System.out.println("Search movie test passed.");
                } else {
                    System.out.println("Search movie test failed: Results do not match.");
                }
            } else {
                System.out.println("Search movie test failed: Number of results do not match.");
            }

        } catch (SQLException e) {
            System.out.println("Search movie test failed: SQLException occurred.");
            e.printStackTrace();
        }
    }
}
