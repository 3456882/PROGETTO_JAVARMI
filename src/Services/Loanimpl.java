/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Metier.Loan;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Utente
 */
public class Loanimpl extends UnicastRemoteObject implements LoanInterface{
    
     public Loanimpl() throws RemoteException {
        super();
    }
    
    @Override
    public boolean addLoan(Loan loan) {
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO loans (user_id, book_id, start_date, return_date,Status) VALUES (?, ?, ?, ?,?)");
            statement.setInt(1, loan.getUserId());
            statement.setInt(2, loan.getBookId());
            statement.setDate(3, new java.sql.Date(loan.getStartDate().getTime()));
            statement.setDate(4, new java.sql.Date(loan.getReturnDate().getTime()));
            statement.setString(5, loan.getStatus());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Loan> getLoansByUserId(int userId) {
        List<Loan> loans = new ArrayList<>();
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM loans WHERE user_id=?");
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Loan loan = new Loan();
                loan.setId(resultSet.getInt("id"));
                loan.setUserId(resultSet.getInt("user_id"));
                loan.setBookId(resultSet.getInt("book_id"));
                loan.setStartDate(resultSet.getDate("start_date"));
                loan.setReturnDate(resultSet.getDate("return_date"));
                loan.setStatus(resultSet.getString("Status"));
                loans.add(loan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loans;
    }

    // Implementazioni delle altre operazioni CRUD per i prestiti

    @Override
    public List<Loan> getLoansByBookId(int bookId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Loan getLoanById(int loanId) {
        try {
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM loans WHERE id=?");
        statement.setInt(1, loanId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Loan loan = new Loan();
            loan.setId(resultSet.getInt("id"));
            loan.setUserId(resultSet.getInt("user_id"));
            loan.setBookId(resultSet.getInt("book_id"));
            loan.setStartDate(resultSet.getDate("start_date"));
            loan.setReturnDate(resultSet.getDate("return_date"));
            loan.setStatus(resultSet.getString("Status"));
            return loan;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
    }

    @Override
    public boolean updateLoan(Loan loan) {
         try {
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE loans SET user_id=?, book_id=?, start_date=?, return_date=?, Status=? WHERE id=?");
        statement.setInt(1, loan.getUserId());
        statement.setInt(2, loan.getBookId());
        statement.setDate(3, new java.sql.Date(loan.getStartDate().getTime()));
        statement.setDate(4, new java.sql.Date(loan.getReturnDate().getTime()));
        statement.setString(5, loan.getStatus());
        statement.setInt(6, loan.getId());
        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
    }

    @Override
    public boolean deleteLoan(int loanId) {
      try {
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM loans WHERE id=?");
        statement.setInt(1, loanId);
        int rowsDeleted = statement.executeUpdate();
        return rowsDeleted > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
    }

    @Override
    public List<Loan> getAllLoans() throws RemoteException {
        
        
        List<Loan> loans = new ArrayList<>();
        try {
            Connection connection = DatabaseManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM loans");
            while (resultSet.next()) {
                Loan loan = new Loan();
                loan.setId(resultSet.getInt("id"));
                loan.setUserId(resultSet.getInt("user_id"));
                loan.setBookId(resultSet.getInt("book_id"));
                loan.setStartDate(resultSet.getDate("start_date"));
                loan.setReturnDate(resultSet.getDate("return_date"));
                 loan.setStatus(resultSet.getString("Status"));
                loans.add(loan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loans;
     
    }
     @Override
    public List<Loan> searchLoans(String searchTerm) throws RemoteException {
        List<Loan> searchResults = new ArrayList<>();
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM loans WHERE start_date LIKE ? OR return_date LIKE ?");
            statement.setString(1, "%" + searchTerm + "%");
            statement.setString(2, "%" + searchTerm + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                
                 Loan loan = new Loan();
                loan.setId(resultSet.getInt("id"));
                loan.setUserId(resultSet.getInt("user_id"));
                loan.setBookId(resultSet.getInt("book_id"));
                loan.setStartDate(resultSet.getDate("start_date"));
                loan.setReturnDate(resultSet.getDate("return_date"));
                 loan.setStatus(resultSet.getString("Status"));
                searchResults.add(loan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return searchResults;
    }
    
}

    

