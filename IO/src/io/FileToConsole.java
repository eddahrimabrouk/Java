/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author USUARIO
 */
public class FileToConsole {
    public static void main(String[] args) {
	    FileInputStream fis = null;
	    File f = new File("fichier.txt");
	    try {
	       fis = new FileInputStream(f);
	       byte[] buf = new byte[8];
	       int n = 0;
	       while ((n = fis.read(buf)) >= 0) {
	          for(int i=0;i<n;i++) System.out.print((char)buf[i]);
	       }
	       System.out.println("Copie terminée !");
	    }
	    catch (FileNotFoundException e) {e.printStackTrace();}
	    catch (IOException e) {e.printStackTrace();} 
	    finally {
	    	try {
	    		if (fis != null) fis.close();
	    	} catch (IOException e) {e.printStackTrace();}
	    }
	 }
}
