package Blog;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String password;

    public User(String firstName, String lastName, String nickName, String password) {
        this.id = Blog.identifier++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.password = password;
    }

    public String getPasswordInStars() {
        String passwordInStars = "";
        for (int i = 0; i < password.length(); i++) {
            passwordInStars = passwordInStars + "*";
        }
        return passwordInStars;
    }

    @Override
    public String toString() {
        return "Imię: " + firstName + '\n' +
                "Nazwisko: " + lastName + '\n' +
                "Nick: " + nickName + '\n' +
                "Hasło: " + getPasswordInStars()
                ;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
