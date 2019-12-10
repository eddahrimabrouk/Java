/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author USUARIO
 */
public class FileCPnio {
    public static void main(String[] args) {
		FileInputStream fis;
		BufferedInputStream bis;
		FileChannel fc;
		try {
			fis = new FileInputStream(new File("fichier.txt"));
			bis = new BufferedInputStream(fis);
			long time = System.currentTimeMillis();
			while(bis.read() != -1);
			System.out.println("Temps d'exécution avec BufferedInputStream : " + (System.currentTimeMillis() - time));
			fis = new FileInputStream(new File("fichier.txt"));
			fc = fis.getChannel();
			int size = (int)fc.size();
			ByteBuffer bBuff = ByteBuffer.allocate(size);
			time = System.currentTimeMillis();
			fc.read(bBuff);
			bBuff.flip();
			System.out.println("Temps d'exécution avec FileChannel : " + (System.currentTimeMillis() - time));
			byte[] tabByte = bBuff.array();
		} catch (FileNotFoundException e) {e.printStackTrace();}
			catch (IOException e) {e.printStackTrace();}
	}
}
