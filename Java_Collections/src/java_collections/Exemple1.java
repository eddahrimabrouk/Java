/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_collections;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author USUARIO
 */
public class Exemple1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ArrayList<String> list = new ArrayList<String>();
       list.add("1");
       list.add("2");
       list.add("3");
       list.add("4");
       list.add("5");
       Iterator it = list.iterator();
       while(it.hasNext()){
           String str = (String)it.next();
           if(str.equals("4")|| str.equals("2")) it.remove();
       }
       
    }
    
}
