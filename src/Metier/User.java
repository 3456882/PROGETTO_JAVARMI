/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

/**
 *
 * @author Utente
 */
import java.io.Serializable;
import java.util.Date;

// Classe che rappresenta un utente del sistema di gestione della biblioteca
public class User implements Serializable{
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    // Costruttore
    public User() {
        super();
    }
    public User(String username, String password, String firstName, String lastName, String email) {
       super();
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(int id, String username, String password, String firstName, String lastName, String email) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Metodi Getter e Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Override del metodo toString per rappresentare l'oggetto User come stringa
    @Override
     public String toString() {
        return firstName + " " + lastName + " (" + username + ")";
    
    //public String toString() {
       // return "User{" +
              //  "id=" + id +
               // ", username='" + username + '\'' +
               // ", password='" + password + '\'' +
               // ", firstName='" + firstName + '\'' +
               // ", lastName='" + lastName + '\'' +
               // ", email='" + email + '\'' +
                //'}';
    }
}
