/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

//import java.io.Serializable;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Utente
 */
// Classe che rappresenta un prestito di un libro da parte di un utente
public class Loan implements Serializable {

    /**
     * @return the Status
     */
   
    private int id;
    private int userId;
    private int bookId;
    private Date startDate;
    private Date returnDate;
    private String Status;

    // Costruttore
    public Loan() {
    }

    // Metodi Getter e Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
     public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Loan(int id, int userId, int bookId, Date startDate, Date returnDate,String Status) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.Status=Status;
    }
    public Loan(int userId, int bookId, Date startDate, Date returnDate,String Status) {
        this.userId = userId;
        this.bookId = bookId;
        this.startDate = startDate;
        this.returnDate = returnDate;
         this.Status=Status;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    // Override del metodo toString per rappresentare l'oggetto Loan come stringa
    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", startDate=" + startDate +
                ", returnDate=" + returnDate +
                 ", Status=" + Status +
                '}';
    }
}
