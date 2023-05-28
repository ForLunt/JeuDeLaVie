package com.jeuDeLaVie;

/**
* @author Pechon
* @version 0.1 : Date : Tue Apr 04 14:41:51 CEST 2023
*
*/
public abstract class Visiteur {
	protected JeuDeLaVie jeu;
	Visiteur(JeuDeLaVie j){
		this.jeu=j;
	}
	/**
	 * visiteCelluleVivante permet de changer l'état d'une cellule vivante
	 */
	public abstract void visiteCelluleVivante(Cellule cellule);
	/**
	 * visiteCelluleMorte permet de changer l'état d'une cellule Morte
	 */
	public abstract void visiteCelluleMorte(Cellule cellule);
	
}