/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.*;

/**
 *
 * @author USUARIO
 */
public class FichierTxt {
    
    public static void main(String[] args) {      
		File file = new File("fichie.txt");
	    FileWriter fw;
	    FileReader fr;
	    try {
	    	fw = new FileWriter(file);
	    	String str = "Bonjour à tous\n";
	    	str += "\tComment allez-vous ? \n";
	    	fw.write(str);
	    	fw.close();
	    	fr = new FileReader(file);
	    	str = "";
	    	int i = 0;
	    	while((i = fr.read()) != -1) str += (char)i;
	    	System.out.println(str);
	    } catch (FileNotFoundException e) {e.printStackTrace();}
	    	catch (IOException e) {e.printStackTrace();}
	}
}
