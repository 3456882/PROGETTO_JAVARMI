/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Metier.Book;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Utente
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;


public class BookIMPL extends UnicastRemoteObject implements Bookinterface{
    
     public BookIMPL() throws RemoteException {
        super();
    }
     @Override
    public boolean addBook(Book book) throws RemoteException  {
        try {
             
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO books (title, author, category, quantity) VALUES (?, ?, ?, ?)");
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getCategory());
            statement.setInt(4, book.getQuantity());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

     @Override
    public List<Book> getAllBooks() throws RemoteException  {
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = DatabaseManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
            while (resultSet.next()) {
                Book book = new Book();
                book.setIdbook(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setCategory(resultSet.getString("category"));
                book.setQuantity(resultSet.getInt("quantity"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

     @Override
    public boolean updateBook(Book book) throws RemoteException {
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE books SET title=?, author=?, category=?, quantity=? WHERE id=?");
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getCategory());
            statement.setInt(4, book.getQuantity());
            statement.setInt(5, book.getIdbook());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

     @Override
    public boolean deleteBook(int bookId) throws RemoteException {
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM books WHERE id=?");
            statement.setInt(1, bookId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Book getBookById(int bookId) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     @Override
    public List<Book> searchBooks(String searchTerm) throws RemoteException {
        List<Book> searchResults = new ArrayList<>();
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM books WHERE title LIKE ? OR author LIKE ?");
            statement.setString(1, "%" + searchTerm + "%");
            statement.setString(2, "%" + searchTerm + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setIdbook(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setCategory(resultSet.getString("category"));
                book.setQuantity(resultSet.getInt("quantity"));
                searchResults.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return searchResults;
    }
    
    
     @Override
    public int getBookIdByName(String title) throws RemoteException {
    int bookId = -1; // valore di default nel caso in cui l'utente non sia trovato
    try {
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT id FROM books WHERE title = ?");
        statement.setString(1, title);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            bookId = resultSet.getInt("id");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return bookId;
}
}

