/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_collections;

/**
 *
 * @author USUARIO
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MainCD {
   public static void main(String[] args) {
      List<CD> list = new ArrayList<CD>();
      list.add(new CD("Ha", "ja", 7d));
      list.add(new CD("bo", "ra", 10.25d));
      list.add(new CD("ta", "mi", 10.25d));
      list.add(new CD("de", "Wd", 15.30d));
      System.out.println("Avant le tri : ");
      Iterator<CD> it = list.iterator();
      while(it.hasNext())
         System.out.println(it.next());
      Collections.sort(list);
      System.out.println("Après le tri : ");
      it = list.iterator();
      while(it.hasNext())
         System.out.println(it.next());
   }
}