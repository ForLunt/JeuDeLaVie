/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Thu Apr 13 09:13:22 CEST 2023
*
*/
public class VisiteurDayAndNigth extends Visiteur{
	VisiteurDayAndNigth(JeuDeLaVie j){
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
		if(nbVoi == 1||nbVoi == 2){
			this.jeu.ajouteCommande(new CommandeMeurt(ce));
		}
	}
	/**
	 * visiteCelluleMorte respecte les règle classique ici une cellule est morte
	 * ci seullement-ci la cellule à plus ou moins 3 voisin
	 */
	 @Override
	public void visiteCelluleMorte(Cellule ce){
		int nbVoi = ce.nombreVoisinesVivantes(this.jeu);
		if(nbVoi == 3||nbVoi == 6 || nbVoi == 7 || nbVoi == 8){
			this.jeu.ajouteCommande(new CommandeVit(ce));
		}
	}
}