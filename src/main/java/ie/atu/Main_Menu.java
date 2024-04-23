package ie.atu;

import ie.atu.pool.DatabaseUtils;
import java.sql.*;
public class Main_Menu {
    public void showMovies(){

        String showMovies = "SELECT movie.title, genre.name ,movie.release_date " +

                "FROM movie " +
                "JOIN genre on movie.genre_id = genre.genre_id " +
                "ORDER BY RAND() " +
                "LIMIT 1";

        try (Connection connection = DatabaseUtils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(showMovies)) {

            while (resultSet.next()) {
                String movie = resultSet.getString("title");
                String genre = resultSet.getString("name");

                System.out.println(movie + " - " + genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void showGenres() {
        String showGenres = "SELECT genre.name " +
                "FROM genre " +
                "ORDER BY RAND() " +
                "LIMIT 3";

        try (Connection connection = DatabaseUtils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(showGenres)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String genreName = resultSet.getString("name");

                System.out.println("Genre: " + name );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}