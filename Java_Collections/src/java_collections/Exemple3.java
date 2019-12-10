/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author USUARIO
 */
public class Exemple3 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1,"un");
        map.put(2,"deux");
        map.put(3,"trois");
        map.put(4,"quatre");
        map.put(5,"cinq");
        Set<Entry<Integer, String>> setEntry = map.entrySet();
        Iterator<Entry<Integer, String>> itEntry = setEntry.iterator();
        System.out.println("Parcours d'une Map avec setEntry : ");
        while(itEntry.hasNext()){
            Entry<Integer, String> entry = itEntry.next();
            System.out.println("Valeur pour la cle "+ entry.getKey()+" = "+ entry.getValue());
            
        }
    }
    
}
