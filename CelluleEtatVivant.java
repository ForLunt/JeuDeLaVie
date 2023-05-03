/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Mon Apr 03 11:10:54 CEST 2023
*
*/
public class CelluleEtatVivant implements CelluleEtat{
	private static volatile CelluleEtat instance;
	public static CelluleEtat getInstance(CelluleEtat inst){
		if(instance == null){
			synchronized(CelluleEtatVivant.class){
				if(instance==null){
					instance = new CelluleEtatVivant();
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
		return this;
	}
	/**
	 * meurt permet de faire mourir une cellule
	 */
	 @Override
	public CelluleEtat meurt(){
		return new CelluleEtatMort();
	}
	/**
	 * estVivante permet de regarder si une cellule est vivante ou non
	 * @return Boolean
	 */
	 @Override
	public Boolean estVivante(){
		return true;
	}
	/**
	 * accepte permet d'invoquer la methode su visiteur corespondent
	 */
	 @Override
	 public void accepte(Visiteur v, Cellule ce){
	 	v.visiteCelluleVivante(ce);
	 }
}