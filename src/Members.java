
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AHMAD
 */
public class Members {
    private String name, address, city, memID, type,contact;
    private int borr;
//    private ArrayList<Book> mBooks=new ArrayList();

//    public ArrayList<Book> getmBooks() {
//        return mBooks;
//    }
    
    public Members(String name, String address, String city, String memID, String type,int borr,String contact){
        this.name = name;
        this.address = address;
        this.city = city;
        this.memID = memID;
        this.type = type;
        this.borr = borr;
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getMemID() {
        return memID;
    }

    public String getType() {
        return type;
    }

    public int getBorr() {
        return borr;
    }

    public void setBorr(int borr) {
        this.borr = borr;
    }
    
    
}