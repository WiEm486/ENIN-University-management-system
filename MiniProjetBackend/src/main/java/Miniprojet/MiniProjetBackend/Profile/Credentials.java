package Miniprojet.MiniProjetBackend.Profile;


import lombok.Data;

@Data
public class Credentials {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
