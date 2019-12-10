/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_java;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author USUARIO
 */
public class Processor extends Thread{
    
    public String Pname;
    public MyBuffer buff;
    public HashMap<String, Integer> wordsCounts = new HashMap<String, Integer>();
    
    public Processor(String PName, MyBuffer buff){
        this.Pname = PName;
        this.buff = buff;
    }
    
    @Override
    public void run(){
        Iterator it = buff.data.iterator();
        while (it.hasNext()) {
            processe();  
        }
        
    }
    
    public void processe(){
        int i = 0;
        String str = buff.data.get(i);
        i++;
        this.wordsCounts.put(str, i);
    }
    
    public HashMap<String, Integer> getWordsCounts(){
            
       return this.wordsCounts;
    }
    
}
