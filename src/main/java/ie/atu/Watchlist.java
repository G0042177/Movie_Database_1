package ie.atu;

import ie.atu.pool.DatabaseUtils;

import java.sql.*;
import java.util.Scanner;

public class Watchlist {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your username:");
            String username = scanner.nextLine();
            if (username != null && !username.isEmpty()) {
                showWatchlist(username, scanner);
            } else {
                System.out.println("Invalid username.");
            }
        }
    }

    public static void showWatchlist(String username, Scanner scanner) {
        String selectMoviesSQL = "SELECT movie.movie_name " +
                "FROM watchlist " +
                "JOIN movie ON watchlist.movie_id = movie.movie_id " +
                "JOIN user ON watchlist.user_id = users.user_id " +
                "WHERE user.username = ?";

        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectMoviesSQL)) {
            statement.setString(1, username);

            ResultSet resultSetMovie = statement.executeQuery();

            System.out.println("Movies in your watchlist:");
            int count = 0;
            while (resultSetMovie.next()) {
                count++;
                String movieName = resultSetMovie.getString("movie_name");
                System.out.println(count + ". " + movieName);
            }
            if (count == 0) {
                System.out.println("No movies found in your watchlist.");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while accessing the database.");
            e.printStackTrace();
        }
    }
}

