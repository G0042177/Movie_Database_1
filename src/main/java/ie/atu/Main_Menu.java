package ie.atu;

import ie.atu.pool.DatabaseUtils;
import java.sql.*;
public class Main_Menu {
    public void showMovies() {
        String showMovies = "SELECT movie.movie_title, genre.name " +
                "FROM movie " +
                "JOIN genre on movie.genre_id = genre.genre_id " +
                "ORDER BY RAND() " +
                "LIMIT 5";

        try (Connection connection = DatabaseUtils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(showMovies)) {

            while (resultSet.next()) {
                String movie = resultSet.getString("movie_title");
                String genre = resultSet.getString("name");

                System.out.println(movie + " - " + genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void showGenres() {
        String showGenres = "SELECT * FROM genre.name, FROM genre.genre_name " +
                "ORDER BY RAND() " +
                "LIMIT 3";

        try (Connection connection = DatabaseUtils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(showGenres)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String genreName = resultSet.getString("genre_name");

                System.out.println("Genre: " + name );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}