package com.jeuDeLaVie;

/**
* @author Pechon
* @version 0.1 : Date : Tue Apr 04 14:26:29 CEST 2023
*
*/
public class CommandeMeurt extends Commande{
	CommandeMeurt(Cellule c){
		super(c);
	}
	/**
	 * executer permet de rendre une cellule morte
	 */
	public void executer(){
		this.cellule.meurt();
	}
}