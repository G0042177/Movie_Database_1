package ie.atu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class Movie_Search_Menu {
    public ArrayList<String> searchMovie(Connection conn, Scanner scanner, String userSearch) throws SQLException {
        ArrayList<String> results = new ArrayList<>();

        PreparedStatement stmt = conn.prepareStatement("SELECT movie.title, genre.name " +
                "FROM movie " +
                "JOIN genre ON movie.genre_id = genre.genre_id " +
                "WHERE (movie.title LIKE ? OR genre.name LIKE ?)");
        stmt.setString(1,"%"+userSearch+"%");
        stmt.setString(2,"%"+userSearch+"%");

        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()){
            String movieName = resultSet.getString("title");
            String genreName = resultSet.getString("name");
            results.add(movieName + " - "+ genreName);
        }
        return results;
    }
}
