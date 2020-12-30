


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
public class FileTokenizer {
    private String path, chr;
    ArrayList<String[]> list = new ArrayList<String[]>();

    public FileTokenizer(String path, String chr) throws IOException {
        this.path = path;
        this.chr = chr;
        reader();
    }
    
    private void reader() throws IOException{
       File myfile=new File(path);
       FileReader fileReader=new FileReader(myfile);
       BufferedReader buff=new BufferedReader(fileReader);
       String line;
       while((line=buff.readLine())!=null) { 
           String[] separated = line.split(this.chr);
           this.list.add(separated);
       }      
    }
    
    public String[] get_line(int index){
        return this.list.get(index);
    }
    
    public ArrayList<String[]> getTokkens(){
        return this.list;
    }
     
}

