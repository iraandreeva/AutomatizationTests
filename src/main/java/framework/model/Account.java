package framework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account{

    public String text;
    public String day;
    public String month;
    public String year;
    public String postcode;
    public String country;
    public String state;
    public String phone;
    public String password;
//    public String email = mail;

    public Account(String password) {
        this.password = password;
    }

}
