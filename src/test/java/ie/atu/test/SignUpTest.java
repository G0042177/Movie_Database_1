//Test to make sure Sign_Up works as intended

package ie.atu.test;

import ie.atu.Sign_Up;

public class SignUpTest {

    public static void main(String[] args) {
        testSignUpInitialization();
    }

    public static void testSignUpInitialization() {
        // Arrange the variables
        String name = "John Doe";
        String username = "johndoe";
        String email = "johndoe@gmail.com";
        double dob = 2000.11;
        String gender = "male";
        String country = "USA";

        // Create a Sign_Up object with the provided data
        Sign_Up signUp = new Sign_Up(name, username, dob, email, gender, country);

        //  Compare the actual values with the expected values
        boolean passed = true;

        passed &= assertEquals(name, signUp.getName());
        passed &= assertEquals(username, signUp.getUsername());
        passed &= assertEquals(email, signUp.getEmail());
        passed &= assertEquals(dob, signUp.getDOB());
        passed &= assertEquals(gender, signUp.getGender());
        passed &= assertEquals(country, signUp.getCountry());


        //Print the test result
        if (passed) {
            System.out.println("Sign_Up initialization test passed.");
        } else {
            System.out.println("Sign_Up initialization test failed.");
        }
    }

    // Custom assertEquals method to compare objects
    public static boolean assertEquals(Object expected, Object actual) {
        //Check if both objects are equal
        if (expected == null && actual == null) {
            return true;   //Both null, so consider them equal
        }
        if (expected == null || actual == null) {
            return false;  // One of them is null, so they are not equal
        }
        return expected.equals(actual);
    }
}
