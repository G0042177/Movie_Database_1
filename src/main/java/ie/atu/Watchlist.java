package ie.atu;

import ie.atu.pool.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Watchlist {

    public static void showWatchlist(String username) {
        String selectMoviesSQL = "SELECT movie.title " +
                "FROM watchlist " +
                "JOIN movie ON watchlist.movie_id = movie.movie_id " +
                "JOIN user ON watchlist.user_id = user.user_id " +
                "WHERE user.username = ?";

        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectMoviesSQL)) {
            statement.setString(1, username);

            ResultSet resultSetMovie = statement.executeQuery();

            System.out.println("Movies in your watchlist:");
            int count = 0;
            while (resultSetMovie.next()) {
                count++;
                String movieName = resultSetMovie.getString("title");
                System.out.println(count + ". " + movieName);
            }
            if (count == 0) {
                System.out.println("No movies found in your watchlist.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
