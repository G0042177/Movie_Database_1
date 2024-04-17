package ie.atu;

public class Login_Info {
    private String Name;
    private String Username;
    private double DOB;
    private String Email;
    private String Gender;
    private String Country;

    public Login_Info(String name, String username, double dob, String email, String gender, String country) {
        this.Name = name;
        this.Username = username;
        this.DOB = dob;
        this.Email = email;
        this.Gender = gender;
        this.Country = country;
    }

    public String getName() {
        return Name;
    }

    public String getUsername() {
        return Username;
    }

    public double getDOB() {
        return DOB;
    }

    public String getEmail() {
        return Email;
    }

    public String getGender() {
        return Gender;
    }

    public String getCountry() {
        return Country;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setDOB(double DOB) {
        this.DOB = DOB;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setCountry(String country) {
        Country = country;
    }
}