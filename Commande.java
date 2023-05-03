/**
* @author Pechon
* @version 0.1 : Date : Tue Apr 04 14:21:09 CEST 2023
*
*/
public abstract class Commande {
	protected Cellule cellule;
	Commande(Cellule c){
		this.cellule=c;
	}
	/**
	 * executer permet d'executer la commande
	 */
	public void executer(){
	}
	
}