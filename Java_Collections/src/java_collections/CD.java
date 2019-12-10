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
public class CD implements Comparable{
	   private String auteur, titre;
	   private double prix;
	   public CD(String auteur, String titre, double prix) {
	      this.auteur = auteur;
	      this.titre = titre;
	      this.prix = prix;
	   }
	   public String toString() {
	      return "CD [auteur=" + auteur + ", titre=" + titre + ", prix=" + prix + "]";
	   }
	   @Override
	   public int compareTo(Object o) {
	      if(o.getClass().equals(CD.class)){
	         CD cd = (CD)o;
	         return this.auteur.compareTo(cd.getAuteur());
	      }
	      return -1;
	   }
	   public String getAuteur() {
	      return auteur;
	   }
	   public String getTitre() {
	      return titre;
	   }
	   public double getPrix() {
	      return prix;
	   }
	}