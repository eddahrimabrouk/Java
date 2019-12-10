/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author USUARIO
 */
public class Exemple2 {
    public static void main(String[] args) {
        
  
    Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "un");
        map.put(2, "deux");
        map.put(3, "trois");
        map.put(4, "quatre");
        map.put(5, "cinq");
        Set<Integer> setInt = map.keySet();
        Iterator<Integer> it = setInt.iterator();
        System.out.println("Parcours d'une Map avec keySet : ");
        while(it.hasNext()){
            int key = it.next();
            System.out.println("Valeur pour la cle "+key+"="+map.get(key));
        }
        

      }
    
}
