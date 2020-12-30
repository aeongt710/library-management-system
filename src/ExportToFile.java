


import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AHMAD
 */
public class ExportToFile {
    String path;

    public ExportToFile(String path) {
        this.path = path;
        
    }
    public void writetofile(String wr) throws IOException{
        FileWriter writer = new FileWriter(path, true);
        writer.write(wr);
        writer.write("\n");
        writer.close();
    }
    
    public void clearContents() throws IOException{
        FileWriter writer = new FileWriter(path);
        writer.close();
    }
    
}
