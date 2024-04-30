/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientRmi;

/**
 *
 * @author Utente
 */
import java.util.regex.Pattern;

public class EmailValidator {

    private static final String EMAIL_PATTERN = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean isValid(String email) {
        return pattern.matcher(email).matches();
    }

    public static void main(String[] args) {
        String[] emails = {"test@example.com", "invalid_email", "another@example.com"};

        for (String email : emails) {
            System.out.println(email + " is valid? " + isValid(email));
        }
    }
}

