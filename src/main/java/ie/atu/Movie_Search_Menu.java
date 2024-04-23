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
                "SELECT movie.title, movie.release_date, movie.rating, movie.synopsis, movie.movie_id, genre.name AS genre, director.name AS director, " +
                        "GROUP_CONCAT(actors.name ORDER BY movie_actor.movie_id SEPARATOR ', ') AS actors " +
                        "FROM movie " +
                        "JOIN genre ON movie.genre_id = genre.genre_id " +
                        "JOIN director ON movie.director_id = director.director_id " +
                        "LEFT JOIN movie_actor ON movie.movie_id = movie_actor.movie_id " +
                        "LEFT JOIN actors ON movie_actor.actor_id = actors.actors_id " +
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
            String movie_id = resultSet.getString("movie_id");

            results.add("Movie Title: " + movieName +
                    "\nRelease Date: " + releaseDate +
                    "\nRating: " + rating +
                    "\nGenre: " + genreName +
                    "\nDirector: " + directorName +
                    "\nActors: " + actors +
                    "\nSynopsis: " + synopsis +
                    "\nMovie ID: " + movie_id );
        }
        return results;
    }
    // Method to add a movie to the watchlist
    public void addToWatchlist(Connection conn, int movieId, String username) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO watchlist (user_id, movie_id) VALUES (?, ?)");
        stmt.setInt(1, getUserIdByUsername(conn, username));
        stmt.setInt(2, movieId);
        stmt.executeUpdate();
    }

    // Method to add a movie to favorites
    public void addToFavorites(Connection conn, int movieId, String username) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO favorite_movies (user_id, movie_id) VALUES (?, ?)");
        stmt.setInt(1, getUserIdByUsername(conn, username));
        stmt.setInt(2, movieId);
        stmt.executeUpdate();
    }

    // Helper method to get user ID by username
    private int getUserIdByUsername(Connection conn, String username) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT user_id FROM user WHERE username = ?");
        stmt.setString(1, username);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("user_id");
        } else {
            throw new SQLException("User not found");
        }
    }
}


