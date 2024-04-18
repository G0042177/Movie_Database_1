package ie.atu.test;

import ie.atu.Sign_Up;

public class SignUpTest {

    public static void main(String[] args) {
        testSignUpInitialization();
    }

    public static void testSignUpInitialization() {
        // Arrange
        String name = "John Doe";
        String username = "johndoe";
        String email = "johndoe@example.com";
        double dob = 1988.05; // Assuming date of birth is represented as a double
        String gender = "male";
        String country = "USA";

        // Act
        Sign_Up signUp = new Sign_Up(name, username, dob, email, gender, country);

        // Assert
        boolean passed = true;

        passed &= assertEquals(name, signUp.getName());
        passed &= assertEquals(username, signUp.getUsername());
        passed &= assertEquals(email, signUp.getEmail());
        passed &= assertEquals(dob, signUp.getDOB()); // Double comparison with a delta of 0
        passed &= assertEquals(gender, signUp.getGender());
        passed &= assertEquals(country, signUp.getCountry());

        if (passed) {
            System.out.println("Sign_Up initialization test passed.");
        } else {
            System.out.println("Sign_Up initialization test failed.");
        }
    }

    // Custom assertEquals method to compare objects
    public static boolean assertEquals(Object expected, Object actual) {
        if (expected == null && actual == null) {
            return true;
        }
        if (expected == null || actual == null) {
            return false;
        }
        return expected.equals(actual);
    }
}
