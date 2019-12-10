/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_collections;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author USUARIO
 */
public class Exemple5 {
    public static void main(String[] args) {
        Set<String> tree = new TreeSet<String>();
        tree.add("Naima");
        tree.add("Yassine");
        tree.add("Mouna");
        tree.add("Oussama");
        tree.add("Assma");
        tree.add("Nassima");
        Iterator<String> it = tree.iterator();
        while(it.hasNext())System.out.println(it.next());
        
    }
}
