/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_java;

import java.util.LinkedList;

/**
 *
 * @author USUARIO
 */
public class MyBuffer {
    
    public int size;
    public LinkedList<String> data = new LinkedList<String>();
    
    public MyBuffer(int size){
        this.size = size;
    }
    
    public void addWord(String str){
        data.add(str);
    
    }
    
    
}
