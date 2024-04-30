/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

import java.io.Serializable;

/**
 *
 * @author Utente
 */
public class Book implements Serializable {

    /**
     * @return the Title
     */
   
    
     private int idbook;
     private String Title;
       private String Author;
       private String Category;
       private int Quantity;

    public Book() {
        super();
    }

    public Book(String Title, String Author, String Category, int Quantity) {
        super();
        this.Title=Title;
        this.Author = Author;
        this.Category = Category;
        this.Quantity = Quantity;
    }
    public Book(int idbook,String Title, String Author, String Category, int Quantity) {
        super();
        this.idbook=idbook;
        this.Title=Title;
        this.Author = Author;
        this.Category = Category;
        this.Quantity = Quantity;
    }

    
    

    /**
     * @return the idbook
     */
    public int getIdbook() {
        return idbook;
    }

    /**
     * @param idbook the idbook to set
     */
    public void setIdbook(int idbook) {
        this.idbook = idbook;
    }
    
     public String getTitle() {
        return Title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * @return the Author
     */
    public String getAuthor() {
        return Author;
    }

    /**
     * @param Author the Author to set
     */
    public void setAuthor(String Author) {
        this.Author = Author;
    }

    /**
     * @return the Category
     */
    public String getCategory() {
        return Category;
    }

    /**
     * @param Category the Category to set
     */
    public void setCategory(String Category) {
        this.Category = Category;
    }

    /**
     * @return the Quantity
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * @param Quantity the Quantity to set
     */
    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
    
    // Override del metodo toString per rappresentare l'oggetto Book come stringa
    @Override
    public String toString() {
        return "Book{" +
                "id=" + idbook +
                ", title='" + Title + '\'' +
                ", author='" + Author + '\'' +
                ", category='" + Category + '\'' +
                ", quantity=" + Quantity +
                '}';
    }
      
       
    
}
