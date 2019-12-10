/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.Serializable;

/**
 *
 * @author USUARIO
 */
public class Game implements Serializable{
	private String nom, style;
	private double prix;
	private transient Atype type;
	public Game(String nom, String style, double prix) {
	    this.nom = nom;
	    this.style = style;
	    this.prix = prix;
	    type=new Atype(5);
	}
	public String toString(){
		return "Nom du jeu : " + this.nom + "\n Style de jeu : " + 
				this.style + "\n Prix du jeu : " + this.prix + "\n";
	} 
}
