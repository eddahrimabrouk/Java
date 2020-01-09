/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionEleves;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author USUARIO
 */
public class FileStatistics {
    private String filename;
    
    public FileStatistics(String filename){
        this.filename = filename;
    }
    
    public int getCharCount() throws FileNotFoundException, IOException{
        FileInputStream fis = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream (fis);
        DataInputStream dis = new DataInputStream (bis);
        int count = 0;
        
        while(dis.readChar() != -1) {
            count++;
        }
        return count;
    }
    
    public int getWordCount() throws FileNotFoundException, IOException{
        FileInputStream fis = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream (fis);
        DataInputStream dis = new DataInputStream (bis);
        int count =0;
        

         while(dis.readChar() != -1) {
             
             if(dis.readChar() == ' ') count++;
        }
        return count;
    }
    
    public int getSentanceCount() throws FileNotFoundException, IOException{
        FileInputStream fis = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream (fis);
        DataInputStream dis = new DataInputStream (bis);
        int count = 0;
        
        while(dis.readChar() != -1) {
             if(dis.readChar() == '.') count++;
             if(dis.readChar() == '?') count++;
             if(dis.readChar() == '!') count++;
        }
        return count;
    }
    
    public int getParagraphCount() throws FileNotFoundException, IOException{
        FileInputStream fis = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream (fis);
        DataInputStream dis = new DataInputStream (bis);
        int count = 0;
        
        while(dis.readChar() != -1) {
             if(dis.readChar() == '\n') count++;
             if(dis.readChar() == '\r') count++;
        }
        return count;
    }
    
    public void saveCounts(String filename) throws FileNotFoundException, IOException{
    
        FileOutputStream fos = new FileOutputStream(filename);
        BufferedOutputStream bos = new BufferedOutputStream (fos);
        DataOutputStream dis = new DataOutputStream (bos);
        
        int chars = getCharCount();
        int words =getWordCount();
        int sentences = getSentanceCount();
        int paragraph = getParagraphCount();
        
        dis.writeInt(chars);
        dis.writeChar('\n');
        dis.writeInt(words);
        dis.writeChar('\n');
        dis.writeInt(sentences);
        dis.writeChar('\n');
        dis.writeInt(paragraph);

    }
    
    public HashMap<String, Integer> getDictionary(){
    
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Hey", 5);
        map.put("Bye", 5);
        map.put("So", 2);
        map.put("What", 1);
        map.put("Why", 10);
        
        
        
        return map;
    }
    
    
}
