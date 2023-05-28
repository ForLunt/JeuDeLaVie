package com.jeuDeLaVie;

/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Tue Apr 04 14:45:04 CEST 2023
*
*/
public class VisiteurClassique extends Visiteur{
	VisiteurClassique(JeuDeLaVie j){
		super(j);
	}
	/**
	 * visiteCelluleVivante respecte les règle classique ici une cellule est vivante
	 * ci seullement-ci la cellule à 2 ou 3 voisin
	 * @param Cellule à modifier
	 */
	 @Override
	public void visiteCelluleVivante(Cellule ce){
		int nbVoi = ce.nombreVoisinesVivantes(this.jeu);
		if(nbVoi < 2 || nbVoi >3){
			this.jeu.ajouteCommande(new CommandeMeurt(ce));
		}else{
			this.jeu.ajouteCommande(new CommandeVit(ce));
		}
	}
	/**
	 * visiteCelluleMorte respecte les règle classique ici une cellule est morte
	 * ci seullement-ci la cellule à plus ou moins 3 voisin
	 */
	 @Override
	public void visiteCelluleMorte(Cellule ce){
		int nbVoi = ce.nombreVoisinesVivantes(this.jeu);
		if(nbVoi == 3){
			this.jeu.ajouteCommande(new CommandeVit(ce));
		}
	}
	
}