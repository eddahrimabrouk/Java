/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionEleves;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author USUARIO
 */
public class GroupeEleves {
    private ArrayList<Eleve> listeEleves = new ArrayList<Eleve>();

	public GroupeEleves() {
	}

	public int nombre() {
		return this.listeEleves.size();
	}

	public ArrayList<Eleve> getListe() {
		return this.listeEleves;
	}

	public void ajouterEleve(Eleve eleve) {
		this.listeEleves.add(eleve);
	}

	public Eleve chercher(String nom) {
		for (Eleve eleve : this.listeEleves) 
			if (eleve.getNom().equals(nom)) return eleve;
		return null;
	}

	public void lister() {
		System.out.println("Liste des eleves : ");
		for (Eleve eleve : listeEleves) {
			System.out.println(eleve);
		}
	}
        
       public Eleve meilleurEleve() {
		return Collections.max(listeEleves);
	}
       
       public void trierEleves() {
		Collections.sort(listeEleves);
	}

}
