package Entity;

public abstract class User {
    private String nama,password;

    public User(String nama, String password) {
        this.nama = nama;
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return nama;
    }
}
