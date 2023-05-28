package com.jeuDeLaVie;

/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Mon Apr 03 13:16:13 CEST 2023
*
*/
public interface Observable {
	/**
	 * attacheObserbateur permet d'ajouter un observateur à la list
	 * @param Observateur à ajouter
	 */
	public void attacheObservateur(Observateur o);
	/**
	 * detacheObservateur permet de suprimmer l'obervateur de la list
	 * @param Observateur à suprimmer
	 */
	public void detacheObservateur(Observateur o);
	/**
	 * notifieObservateur permet d'appeller tout les observateurs
	 */
	public void notifieObservateurs();
}