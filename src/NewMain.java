
import java.io.IOException;
import java.util.ArrayList;
import java.lang.String;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// String d = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/mm/dd"));
//        System.out.println(d);
/**
 *
 * @author AHMAD
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Book> books=new ArrayList();
    static ArrayList<Members> mems=new ArrayList();
    static ArrayList<Borrowed> borrow=new ArrayList();
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
     
        
        
        String d = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy (hh:mm:ss)"));
        System.out.println(d);
        Functions f=new Functions();
        System.out.println(f.getB_logs().size());
        
//        load_books();
//        load_mems();
//        load_borrowed();
        System.out.println(borrow.size());
        
    }
    public static void load_files() throws IOException{
        load_mems();
        load_books();
        load_borrowed();
        
    }
    
    
    public static void load_borrowed() throws IOException{
        FileTokenizer tok=new FileTokenizer("Borrowed.txt","!");
        ArrayList<String []> tokkens=tok.getTokkens();
        for(int i=0;i<tokkens.size();i++){
            String a[]=tokkens.get(i);
            borrow.add(new Borrowed(a[0],a[1],a[2]));
        }
    }
    
    //Load Members
    public static void load_mems() throws IOException{
        FileTokenizer mem_tok=new FileTokenizer("Members.txt","!");
        ArrayList<String []> mem_tokkens= mem_tok.getTokkens();
        for(int i=0;i<mem_tokkens.size();i++){
            String a[]=mem_tokkens.get(i);
            mems.add(new Members(a[0],a[1],a[2],a[3],a[4],Integer.parseInt(a[5]),a[6])); 
        } 
    }
    
    
    //Load books
    public static void load_books() throws IOException{
        FileTokenizer mem_tok=new FileTokenizer("Books.txt","!");
        ArrayList<String []> mem_tokkens= mem_tok.getTokkens();
        for(int i=0;i<mem_tokkens.size();i++){
            String a[]=mem_tokkens.get(i);
            books.add(new Book(a[0],a[1],a[2],a[3], Integer. parseInt(a[4]),a[5])); 
        }
    }
    
    //Add member
    static void add_mem() throws IOException{
        String name="Ali", address="Shorkot Cantt", number="0332144235", memID="M"+mems.size(), type="Premium";int borr=3;String city="Cantt";
        mems.add(new Members(name,address,city, memID,type,borr,number));
        String we=name+"!"+address+"!"+number+"!"+memID+"!"+type;
        ExportToFile write=new ExportToFile("Members.txt");
        write.writetofile(we);
    }
    
    //Add Book
    static void add_book() throws IOException{
        String name="OOP Book";String auth="Ahmad";String publ="MA productions";int quantity=12;String cata="Eng";
        String serial_no="B"+books.size();
        books.add(new Book(serial_no,name,auth,publ,quantity,cata));
        String wr=serial_no+"!"+name+"!"+auth+"!"+publ+"!"+quantity+"!"+cata;
        ExportToFile write=new ExportToFile("Books.txt");
        write.writetofile(wr);
    }
}
