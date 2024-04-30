/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientRmi;

/**
 *
 * @author Utente
 */
import Metier.User;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel {
    private String[] columnNames = {"ID", "Username","Password","firstname","Lastname", "Email"};
    private List<User> users;

    public UserTableModel(List<User> users) {
        this.users = users;
    }

    @Override
    public int getRowCount() {
        return users.size();
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
        User user = users.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return user.getId();
            case 1:
                return user.getUsername();
            case 2:
                return user.getPassword();
                case 3:
                return user.getFirstName();
                case 4:
                return user.getLastName();
                case 5:
                return user.getEmail();
            default:
                return null;
        }
    }
    
    // Metodo per ottenere l'utente alla riga specificata
    public User getUserAt(int rowIndex) {
        return users.get(rowIndex);
    }
    
}
