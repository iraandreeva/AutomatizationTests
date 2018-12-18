package framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static framework.PageLogin.mail;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginData {
    public String email;
    public String password;

    public LoginData(String password) {
        this.password = password;
        email = mail;
    }

}