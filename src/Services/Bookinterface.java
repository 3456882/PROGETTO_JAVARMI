/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import Metier.Book;

/**
 *
 * @author Utente
 */
public interface Bookinterface extends Remote {
    
    // Aggiunge un nuovo libro al database
   public boolean addBook(Book book) throws RemoteException;

    // Recupera tutti i libri presenti nel database
   public List<Book> getAllBooks() throws RemoteException;

    // Recupera un libro dal database dato il suo ID
    public Book getBookById(int bookId) throws RemoteException;

    // Aggiorna le informazioni di un libro esistente nel database
    public boolean updateBook(Book book) throws RemoteException;

    // Elimina un libro dal database dato il suo ID
    public boolean deleteBook(int bookId) throws RemoteException;
    
     List<Book> searchBooks(String searchTerm) throws RemoteException;
      public int getBookIdByName(String title) throws RemoteException;
    
}

    

