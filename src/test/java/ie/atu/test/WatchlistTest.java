package ie.atu.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ie.atu.Watchlist;

public class WatchlistTest {
    private WatchlistDAO watchlistDAO; //DAO (Data Access Object)

    //Constructor for Watchlist test class
    public WatchlistTest(WatchlistDAO watchlistDAO) {
        this.watchlistDAO = watchlistDAO;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        WatchlistDAO mockDAO = new MockWatchlistDAO(); // Create a mock DAO
        WatchlistTest watchlistTest = new WatchlistTest(mockDAO);
        watchlistTest.showWatchlist(username);
    }

    public void showWatchlist(String username) {
        //Get the list of movies from the DAO
        List<String> movies = watchlistDAO.getWatchlistMovies(username);

        //Print movies
        System.out.println("Movies in your watchlist:");
        if (movies.isEmpty()) {
            System.out.println("No movies found in your watchlist.");
        } else {
            for (int i = 0; i < movies.size(); i++) {
                System.out.println((i + 1) + ". " + movies.get(i));
            }
        }
    }
}

//Define interface
interface WatchlistDAO {
    List<String> getWatchlistMovies(String username);
}

class MockWatchlistDAO implements WatchlistDAO {
    //Method to simulate getting movies from a database
    @Override
    public List<String> getWatchlistMovies(String username) {

        List<String> movies = new ArrayList<>();
        movies.add("Movie 1");
        movies.add("Movie 2");
        return movies;
    }
}
