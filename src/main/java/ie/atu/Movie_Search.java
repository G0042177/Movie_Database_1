package ie.atu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public interface Movie_Search {
    ArrayList<String> searchMovie(Connection conn, Scanner scanner, String userSearch) throws SQLException;
}
