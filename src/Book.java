/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AHMAD
 */
public class Book {
    private String name, author,publisher, serial_no,catagory;
    private int quantity;

    public Book(String serial_no,String name, String author, String publisher,int quantity,String catagory) {
        this.serial_no=serial_no;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity =quantity;
        this.catagory=catagory;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public String getCatagory() {
        return catagory;
    }
    public boolean getAvailability(){
        if(quantity>0)
            return true;
        else
            return false;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
