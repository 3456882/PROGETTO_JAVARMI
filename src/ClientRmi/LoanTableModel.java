/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientRmi;

/**
 *
 * @author Utente
 */
import Metier.Loan;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class LoanTableModel extends AbstractTableModel {
    private String[] columnNames = {"ID", "User ID", "Book ID", "Date Borrowed", "Date Returned","Statment"};
    private List<Loan> loans;

    public LoanTableModel(List<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public int getRowCount() {
        return loans.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Loan loan = loans.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return loan.getId();
            case 1:
                return loan.getUserId();
            case 2:
                return loan.getBookId();
            case 3:
                //return loan.getDateBorrowed();
                return loan.getStartDate();
            case 4:
                //return loan.getDateReturned();
                return loan.getReturnDate();
            case 5:
                //return loan.getDateReturned();
                return loan.getStatus();
            default:
                return null;
        }
    }
    
    // Metodo per ottenere il prestito alla riga specificata
    public Loan getLoanAt(int rowIndex) {
        return loans.get(rowIndex);
    }
}
