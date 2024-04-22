package ie.atu;
import ie.atu.pool.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Movie_Search_Menu implements Movie_Search {
    @Override
    public ArrayList<String> searchMovie(Connection conn, Scanner scanner, String userSearch) throws SQLException {
        ArrayList<String> results = new ArrayList<>();

        PreparedStatement stmt = conn.prepareStatement(
                "SELECT movie.title, movie.release_date, movie.rating, movie.synopsis, genre.name AS genre, director.name AS director, " +
                        "GROUP_CONCAT(actors.name ORDER BY movie_actor.movie_id SEPARATOR ', ') AS actors " +
                        "FROM movie " +
                        "JOIN genre ON movie.genre_id = genre.genre_id " +
                        "JOIN director ON movie.director_id = director.director_id " +
                        "LEFT JOIN movie_actor ON movie.movie_id = movie_actor.movie_id " +
                        "LEFT JOIN actors ON movie_actor.actors_id = actors.actors_id " +
                        "WHERE (movie.title LIKE ? OR genre.name LIKE ?) " +
                        "GROUP BY movie.movie_id"
        );
        stmt.setString(1, "%" + userSearch + "%");
        stmt.setString(2, "%" + userSearch + "%");

        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            String movieName = resultSet.getString("title");
            String releaseDate = resultSet.getString("release_date");
            double rating = resultSet.getDouble("rating");
            String synopsis = resultSet.getString("synopsis");
            String genreName = resultSet.getString("genre");
            String directorName = resultSet.getString("director");
            String actors = resultSet.getString("actors");

            results.add("Movie Title: " + movieName +
                    "\nRelease Date: " + releaseDate +
                    "\nRating: " + rating +
                    "\nGenre: " + genreName +
                    "\nDirector: " + directorName +
                    "\nActors: " + actors +
                    "\nSynopsis: " + synopsis + "\n");
        }
        return results;
    }
}


