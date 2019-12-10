/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 *
 * @author USUARIO
 */
public class Lecteur {
    
    public String fileName;
    public String threadName;
    public MyBuffer buff;
    
    public Lecteur(String threadName, String fileName, MyBuffer buff){
        this.buff = buff;
        this.fileName = fileName;
        this.threadName = threadName;
    } 
    
    public String readWord() throws FileNotFoundException, IOException{
        File file = new File(fileName); 
        FileReader fr = new FileReader(file);

        String Word = null; 
        int i =0; 
        while((i = fr.read()) != -1) 
        { 
            if((char)i == ' ') return Word;
            Word += (char)i;
        }
        return null;
    }
    
    public void run() throws IOException{
       Iterator it = buff.data.iterator();
       while (it.hasNext()) {
       buff.data.push(readWord());
       }
    }
}
