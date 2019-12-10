/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author USUARIO
 */
public class Exemple4 {
     public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1,"un");
        map.put(2,"deux");
        map.put(3,"trois");
        map.put(4,"quatre");
        map.put(5,"cinq");
        Collection<String> col = map.values();
        Iterator<String> itString = col.iterator();
        System.out.println("Parcours d'une Map avec values : ");
        while(itString.hasNext()){
            String value = itString.next();
            System.out.println("Valeur : "+ value);
        }
    }
}
