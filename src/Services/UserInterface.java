/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;
import Metier.User;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Utente
 */
public interface UserInterface extends Remote{
 
    // Aggiunge un nuovo utente al database
    boolean addUser(User user)throws RemoteException;
    
    public List<User> getAllUsers() throws RemoteException;

    // Recupera un utente dal database dato il suo ID
    User getUserById(int userId)throws RemoteException;

    // Verifica le credenziali di accesso di un utente
    User login(String username, String password)throws RemoteException;

    // Aggiorna le informazioni di un utente esistente nel database
    boolean updateUser(User user)throws RemoteException;

    // Elimina un utente dal database dato il suo ID
    boolean deleteUser(int userId)throws RemoteException;
    
    List<User> searchUsers(String searchTerm) throws RemoteException;
    
    public int getUserIdByName(String first_name) throws RemoteException;

 
}
