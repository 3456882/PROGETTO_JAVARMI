/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Services.BookIMPL;
import Services.Loanimpl;
import Services.Userimpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Utente
 */
public class Newserver {
    private BookIMPL bookdao;
    private Userimpl userdao;
    private Loanimpl loandao;
    public Newserver() throws RemoteException{
        this.bookdao=new BookIMPL();
        this.userdao=new Userimpl();
        this.loandao=new Loanimpl();
        
}
   public static void main(String[] args)  {
           try {
                Registry registry = LocateRegistry.createRegistry(1234);
                 registry.rebind("books",new Newserver().bookdao);
                 registry.rebind("users",new Newserver().userdao);
                 registry.rebind("loans",new Newserver().loandao);
        System.out.println("Server is running............");
        } catch (RemoteException e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
     }
    
    
}
