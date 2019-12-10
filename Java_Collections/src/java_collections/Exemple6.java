/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author USUARIO
 */
public class Exemple6 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(24);
        list.add(14);
        list.add(6);
        list.add(2);
        Collections.sort(list);
        Iterator<Integer> it = list.iterator();
        while(it.hasNext())System.out.println(it.next());
        
    }
    
}
