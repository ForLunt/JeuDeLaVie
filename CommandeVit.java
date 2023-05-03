/**
* @author Pechon
* @version 0.1 : Date : Tue Apr 04 14:23:23 CEST 2023
*
*/
public class CommandeVit extends Commande{
	CommandeVit(Cellule c){
		super(c);
	}
	/**
	 * executer permet de rendre une cellule vivante
	 */
	public void executer(){
		this.cellule.vit();
	}
}