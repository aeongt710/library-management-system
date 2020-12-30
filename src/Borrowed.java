


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AHMAD
 */
public class Borrowed {
    private String bookID,memID, date;

    public Borrowed(String bookID, String memID,String date) {
        this.bookID = bookID;
        this.memID = memID;
        this.date = date;
    }

    public String getBookID() {
        return bookID;
    }

    public String getMemID() {
        return memID;
    }

    public String getDate() {
        return date;
    }
    
}
