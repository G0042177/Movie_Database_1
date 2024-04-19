package ie.atu;

import ie.atu.pool.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Favourites {
    public static void main(String[] args){
        String username = "";
        showFavorites(username);
    }
    public static void showFavorites(String username) {
        String selectSQL = "SELECT movie.title, genre.name " +
                "FROM movie " +
                "JOIN favorites ON movie.movie_id = favorites.movie_id " +
                "JOIN users ON favorites.user_id = users.user_id " +
                "JOIN genre ON movie.genre_id = genre.genre_id " +
                "WHERE users.username = ?";
        ArrayList<String> favorites = new ArrayList<>();

        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectSQL)){
            statement.setString(1,username);
            ResultSet resultSetFavourite = statement.executeQuery();

            while (resultSetFavourite.next()) {
                String movieName = resultSetFavourite.getString("title");
                String genreName = resultSetFavourite.getString("name");
                favorites.add(movieName + " - "+ genreName);
            }

            if(favorites.size()==0){
                System.out.println("No favorites\n");
            }
            else {
                System.out.println("favorites:");
                for(String myFavourite : favorites){
                    System.out.println(favorites);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
