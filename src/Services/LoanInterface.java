/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;
import Metier.Loan;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Utente
 */
public interface LoanInterface extends Remote{
  
    // Registra un nuovo prestito nel database
    boolean addLoan(Loan loan) throws RemoteException;

    // Recupera tutti i prestiti effettuati da un utente dato il suo ID
    List<Loan> getLoansByUserId(int userId) throws RemoteException;

    // Recupera tutti i prestiti relativi a un libro dato il suo ID
    List<Loan> getLoansByBookId(int bookId) throws RemoteException;

     List<Loan> searchLoans(String searchTerm) throws RemoteException;
    // Restituisce un prestito dato il suo ID
    Loan getLoanById(int loanId) throws RemoteException;

    // Aggiorna le informazioni di un prestito esistente nel database
    boolean updateLoan(Loan loan) throws RemoteException;

    // Elimina un prestito dal database dato il suo ID
    boolean deleteLoan(int loanId) throws RemoteException;
    
     public List<Loan> getAllLoans() throws RemoteException;
}


