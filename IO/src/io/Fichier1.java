/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.File;

/**
 *
 * @author USUARIO
 */
public class Fichier1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f = new File("fichier.txt");
    System.out.println("Chemin absolu du fichier : " + f.getAbsolutePath());
    System.out.println("Est-ce qu'il existe ? " + f.exists());
    System.out.println("Est-ce un répertoire ? " + f.isDirectory());
    System.out.println("Affichage des lecteurs à la racine du PC : ");
    for(File file : File.listRoots()){
      System.out.println(file.getAbsolutePath());
      try {
        int i = 1;  
        for(File nom : file.listFiles()){
        	System.out.print("\t\t" + ((nom.isDirectory()) ? nom.getName()+"/" : nom.getName()));
        	if((i%5) == 0){
        		System.out.print("\n");
        	}
        	i++;
        }
        System.out.println("\n");
      } catch (NullPointerException e) {}
    }       
  }

    }
    

