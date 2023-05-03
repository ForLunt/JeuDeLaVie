/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Mon Apr 03 11:12:32 CEST 2023
*
*/
public class CelluleEtatMort implements CelluleEtat {
	private static volatile CelluleEtat instance;
	public static CelluleEtat getInstance(CelluleEtat inst){
		if(instance == null){
			synchronized(CelluleEtatVivant.class){
				if(instance==null){
					instance = new CelluleEtatMort();
				}
			}
		}
		return instance;
	}
	/**
	 * vit permet de rendre vivante une cellule
	 */
	 @Override
	public CelluleEtat vit(){
		return new CelluleEtatVivant();
	}
	/**
	 * meurt permet de faire mourir une cellule
	 */
	 @Override
	public CelluleEtat meurt(){
		return this;
	}
	/**
	 * estVivante permet de regarder si une cellule est vivante ou non
	 * @return Boolean
	 */
	 @Override
	public Boolean estVivante(){
		return false;
	}
	/**
	 * accepte permet d'invoquer la methode su visiteur corespondent
	 */
	 @Override
	 public void accepte(Visiteur v, Cellule ce){
	 	v.visiteCelluleMorte(ce);
	 }
}