package ie.atu.test;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.SQLException;

import ie.atu.Login;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    @Test
    public void testLogin() throws SQLException {
        // Set up simulated user input
        String input = "L\nusername\npassword\nM\nS\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Redirect System.out to capture console output
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        // Call the main method of Login class
        Login.main(new String[]{});

        // Get the console output
        String consoleOutput = out.toString();

        // Assert that the console output contains the expected strings
        assertEquals(true, consoleOutput.contains("Would you like to: Login or Sign-up? L || S:"));
        assertEquals(true, consoleOutput.contains("Enter username:"));
        assertEquals(true, consoleOutput.contains("Enter password:"));
        assertEquals(true, consoleOutput.contains("Main Menu"));
        assertEquals(true, consoleOutput.contains("Search some Movies"));
        assertEquals(true, consoleOutput.contains("Your Watchlist"));
        assertEquals(true, consoleOutput.contains("Account"));
        assertEquals(true, consoleOutput.contains("Logging out..."));
    }

    @Test
    public void testSignUp() throws SQLException {
        // Set up simulated user input
        String input = "S\nname\nusername\nemail@example.com\n1990-01-01\nmale\nIreland\npassword\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Redirect System.out to capture console output
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        // Call the signUp method of Login class
        Login.signUp(null, new java.util.Scanner(System.in));

        // Get the console output
        String consoleOutput = out.toString();

        // Assert that the console output contains the expected strings
        assertEquals(true, consoleOutput.contains("Enter full name:"));
        assertEquals(true, consoleOutput.contains("Enter username:"));
        assertEquals(true, consoleOutput.contains("Enter email:"));
        assertEquals(true, consoleOutput.contains("Enter DOB XXXX-XX-XX:"));
        assertEquals(true, consoleOutput.contains("Enter gender, male, female or other"));
        assertEquals(true, consoleOutput.contains("Enter country:"));
        assertEquals(true, consoleOutput.contains("Create a password"));
        assertEquals(true, consoleOutput.contains("Congrats, User createdm"));
    }
}

