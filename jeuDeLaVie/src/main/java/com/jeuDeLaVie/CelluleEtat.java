package com.jeuDeLaVie;

/**
* @author Pechon
* @version 0.1 : Date : Mon Apr 03 11:09:16 CEST 2023
*
*/
public interface CelluleEtat {
	/**
	 * vit permet de rendre vivante une cellule
	 */
	public CelluleEtat vit();
	/**
	 * meurt permet de faire mourir une cellule
	 */
	public CelluleEtat meurt();
	/**
	 * estVivante permet de regarder si une cellule est vivante ou non
	 * @return Boolean
	 */
	public Boolean estVivante();
	/**
	 * accepte permet d'invoquer la methode su visiteur corespondent
	 */
	 public void accepte(Visiteur v, Cellule ce);
}