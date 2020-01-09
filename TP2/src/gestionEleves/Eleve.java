/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionEleves;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class Eleve implements Comparable<Eleve>{
    
    private String nom;
    private ArrayList ensembleNotes = new ArrayList<Integer>();
    private double moyenne;
    
    public Eleve(String nom){
        this.nom=nom;
    }
    public double getMoyenne(){
        return this.moyenne;
    }
    public void ajouterNote(int note){
            int nbNotes = this.ensembleNotes.size();
            if (note < 0) note = 0;
            else if (note > 20) note = 20;
            this.moyenne = (this.moyenne * nbNotes + note) / (nbNotes + 1);
            this.ensembleNotes.add(note);
    }
    public String getNom(){
        return this.nom;
    }
    public ArrayList<Integer> getListNotes(){
        return this.ensembleNotes;
    }
    public String toString(){
        return "Nom : "+ this.nom+ "Note : "+ this.getMoyenne();
    }

    @Override
    public int compareTo(Eleve autreEleve) {
        if (this.moyenne < autreEleve.getMoyenne()) return -1;
         if (this.moyenne > autreEleve.getMoyenne()) return 1;
        return 0;
    }
    
    
    
    

}
