package lab.backing;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped @Named
public class LoginBean {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        if (username.equals(password)) {
            return "success";
        } else {
            return "failure";
        }
    }
}
