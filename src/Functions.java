

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class Functions{
    private ArrayList<Book> books=new ArrayList();
    private ArrayList<Members> mems=new ArrayList();
    private ArrayList<Borrowed> borrow=new ArrayList();
    private ArrayList<bookLogs> b_logs=new ArrayList();
    private ArrayList<users> use=new ArrayList();
    
 Functions() throws IOException{
        load_mems();
        load_books();
        load_borrowed();
        load_b_logs();
        load_users();
 }   
        public void load_users() throws IOException{
        FileTokenizer tok=new FileTokenizer("users.txt","!");
        ArrayList<String []> tokkens=tok.getTokkens();
        for(int i=0;i<tokkens.size();i++){
            String a[]=tokkens.get(i);
            use.add(new users(a[0],a[1]));
        }
    }

    public ArrayList<users> getUse() {
        return use;
    }
    public void add_user(String n,String p) throws IOException{
        ExportToFile ex=new ExportToFile("users.txt");
        this.use.add(new users(n,p));
        String w=n+"!"+p;
        ex.writetofile(w);
    }
 
    public boolean return_book(String b_ID,String m_ID) throws IOException{
        Borrowed x;
        for(int i=0;i<borrow.size();i++){
            if(borrow.get(i).getBookID().equalsIgnoreCase(b_ID)&&borrow.get(i).getMemID().equalsIgnoreCase(m_ID)){
                x=borrow.get(i);
                borrow.remove(i);
                
                for(int j=0;j<mems.size();j++){
                    if(mems.get(j).getMemID().equalsIgnoreCase(m_ID)){
                        mems.get(j).setBorr(mems.get(j).getBorr()+1);
                        break;
                    }
                }
                
                for(int k=0;k<books.size();k++){
                    if(books.get(k).getSerial_no().equalsIgnoreCase(b_ID)){
                        books.get(k).setQuantity(books.get(k).getQuantity()+1);
                        break;
                    }
                }
                boolean b=returnFiles(x);
                return b;
            }
        }
        return false;
    }

    public ArrayList<bookLogs> getB_logs() {
        return b_logs;
    }
    
    public boolean check_double_borrow(String book,String mem){
        for(int i=0;i<borrow.size();i++){
            if(borrow.get(i).getMemID().equalsIgnoreCase(mem)&&borrow.get(i).getBookID().equalsIgnoreCase(book)){
                return false;
            }
        }
        String d = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy  hh:mm:ss"));
        this.borrow.add(new Borrowed(book,mem,d));
        return true;
    }
    
    public boolean returnFiles(Borrowed x) throws IOException{
        writeboomem();
        ExportToFile ex=new ExportToFile("Borrowed.txt");
        ex.clearContents();
        for(int i=0;i<borrow.size();i++){
            String write=borrow.get(i).getBookID()+"!"+borrow.get(i).getMemID()+"!"+borrow.get(i).getDate();
            ex.writetofile(write);
        }
        ExportToFile ex2=new ExportToFile("report.txt");
        String d = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy  hh:mm:ss"));
        String w=x.getBookID()+"!"+x.getMemID()+"!"+x.getDate()+"!"+d;
        ex2.writetofile(w);
        b_logs.add(new bookLogs(x.getBookID(),x.getMemID(),x.getDate(),d));
        return true;
    }
         public void load_b_logs() throws IOException{
        FileTokenizer mem_tok=new FileTokenizer("report.txt","!");
        ArrayList<String []> mem_tokkens= mem_tok.getTokkens();
        for(int i=0;i<mem_tokkens.size();i++){
            String a[]=mem_tokkens.get(i);
            b_logs.add(new bookLogs(a[0],a[1],a[2],a[3])); 
        } 
    }
 
    public void add_book(Book b) throws IOException{//B4!Html!Hamid!MA productions!12!Eng

        this.books.add(b);
        String wr="B"+this.getBooks().size()+"!"+b.getName()+"!"+b.getAuthor()+"!"+b.getPublisher()+"!"+b.getQuantity()+"!"+b.getCatagory();
        ExportToFile write=new ExportToFile("Books.txt");
        write.writetofile(wr);
        
    }
    public ArrayList<Book> getBooks() {
        return books;
    }
    
    public Members search_member_by_ID(String ID){

        for(int i=0;i<mems.size();i++){
            if(ID.equalsIgnoreCase(mems.get(i).getMemID())){
                return mems.get(i);
            }
        }
        return null;
    }
    
    public Members search_member_by_Name(String name){
        int check=0;
        for(int i=0;i<mems.size();i++){
            if(name.equalsIgnoreCase(mems.get(i).getName())){
                check++;
                return mems.get(i);
            }
        }
        return null;
    }
    public ArrayList<Members> getMems() {
        return mems;
    }

    public ArrayList<Borrowed> getBorrow() {
        return borrow;
    }
   // Ali!Cantt Bazar!Abbottabad!M0!Premium!3!0333152452
//        ExportToFile w=new ExportToFile("Members.txt");
//        w.writetofile(write);
    
    
    public void add_member(Members m) throws java.io.IOException{
        this.mems.add(m);
        String write=m.getName()+"!"+m.getAddress()+"!"+m.getCity()+"!"+m.getMemID()+"!"+m.getType()+"!"+m.getBorr()+"!"+m.getContact();
        ExportToFile w=new ExportToFile("Members.txt");
        w.writetofile(write);
    }
 
    public Book book_search_by_name(String name){
    
        int i=0;
        for(i=0;i<books.size();i++){
            if(name.equalsIgnoreCase(books.get(i).getName())){
                return books.get(i);}
            }
        return null;
    }
    
    public Book book_search_by_ID(String ID){
        int i=0;
        for(i=0;i<books.size();i++){
            if(ID.equalsIgnoreCase(books.get(i).getSerial_no())){
                return books.get(i);}
            }
        return null;
    }
    //load members
     public void load_mems() throws IOException{
        FileTokenizer mem_tok=new FileTokenizer("Members.txt","!");
        ArrayList<String []> mem_tokkens= mem_tok.getTokkens();
        for(int i=0;i<mem_tokkens.size();i++){
            String a[]=mem_tokkens.get(i);
            mems.add(new Members(a[0],a[1],a[2],a[3],a[4],Integer.parseInt(a[5]),a[6])); 
        } 
    }
    
    
    //Load books
    public void load_books() throws IOException{
        FileTokenizer mem_tok=new FileTokenizer("Books.txt","!");
        ArrayList<String []> mem_tokkens= mem_tok.getTokkens();
        for(int i=0;i<mem_tokkens.size();i++){
            String a[]=mem_tokkens.get(i);
            books.add(new Book(a[0],a[1],a[2],a[3], Integer. parseInt(a[4]),a[5])); 
        }
    }
    //load borrowed
        public void load_borrowed() throws IOException{
        FileTokenizer tok=new FileTokenizer("Borrowed.txt","!");
        ArrayList<String []> tokkens=tok.getTokkens();
        for(int i=0;i<tokkens.size();i++){
            String a[]=tokkens.get(i);
            borrow.add(new Borrowed(a[0],a[1],a[2]));
        }
    }
        
        public ArrayList<Book> borrowed_book_by_id(String id){
            ArrayList<Book> b=new ArrayList<>();int check=0;
            for(int i=0;i<borrow.size();i++){
                if(id.equals(borrow.get(i).getMemID())){
                    check++;
                    b.add(book_search_by_ID(borrow.get(i).getBookID()));
                }    
            }
            if(check!=0){
                return b;
            }  
            else
                return null;
        }  
        public void write_borrow(String memID,String booID) throws IOException{
            String d = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy (hh:mm:ss)"));
            String write=booID+"!"+memID+"!"+d;
            ExportToFile ex=new ExportToFile("Borrowed.txt");
            ex.writetofile(write);
        }
        public void writeboomem() throws IOException{
            ExportToFile me=new  ExportToFile("Members.txt");
            me.clearContents();
            for(int i=0;i<mems.size();i++){
                String member=mems.get(i).getName()+"!"+mems.get(i).getAddress()+"!"+mems.get(i).getCity()+"!"+mems.get(i).getMemID()+"!"+mems.get(i).getType()+"!"+mems.get(i).getBorr()+"!"+mems.get(i).getContact();
                me.writetofile(member);
            }
            ExportToFile bk=new  ExportToFile("Books.txt");
            bk.clearContents();
            for(int i=0;i<books.size();i++){
                String bks=books.get(i).getSerial_no()+"!"+books.get(i).getName()+"!"+books.get(i).getAuthor()+"!"+books.get(i).getPublisher()+"!"+books.get(i).getQuantity()+"!"+books.get(i).getCatagory();
                bk.writetofile(bks);
            }
            
            
        }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void setMems(ArrayList<Members> mems) {
        this.mems = mems;
    }

    public void setBorrow(ArrayList<Borrowed> borrow) {
        this.borrow = borrow;
    }
    
}
