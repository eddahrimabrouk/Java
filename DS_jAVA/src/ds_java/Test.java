/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_java;

import java.io.IOException;

/**
 *
 * @author USUARIO
 */
public class Test {
    public static void main(String[] args) throws IOException {
        MyBuffer buff = new MyBuffer(100);
        new Processor("A",buff).start();
        new Processor("B",buff).start();
        
        Lecteur lec1 = new Lecteur("1","file.txt",buff);
        Lecteur lec2 = new Lecteur("2","file1.txt",buff);
        
        
        
    }
    
}
