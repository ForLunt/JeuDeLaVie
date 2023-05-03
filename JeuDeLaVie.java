/**
* @author Pechon
* @version 0.1 : Date : Mon Apr 03 13:02:08 CEST 2023
*
*/
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class JeuDeLaVie implements Observable {
	private List <Observateur> observateur;
	private List <Commande> commandes ;
	private Cellule[][] grille;
	private static int xMax=145;
	private static int yMax=100;
	private Visiteur vis;
	JeuDeLaVie(){
		this.grille=new Cellule[this.xMax][this.yMax];
		this.observateur=new ArrayList <Observateur>();
		this.commandes=new ArrayList <Commande>();
		this.vis=new VisiteurClassique(this);
	}
	
	public int getXMax(){
		return this.xMax;
	}
	public int getYMax(){
		return this.yMax;
	}
	public void setXMax(int xMax){
		this.xMax=xMax;
	}
	public void setYMax(int yMax){
		this.yMax=yMax;
	}
	/**
	 * modVis permet de modifier le visiteur.
	 * par défaut le visiteur suit les règles classique avec VisiteurClassique
	 * @param Visiteur par le quelle il faut remplacer 
	 */
	public void modVis(Visiteur v){
		this.vis=v;
	}
	/**
	 * initialiseGrille permet n'initialiser la grille de départ
	 */
	public void initialiseGrille(){
		for(int x=0; x<this.xMax; x++){
			for(int y=0;y<this.yMax;y++){
				double rand= Math.random();
				if(rand <0.5){
					this.grille[x][y]=new Cellule(x,y,new CelluleEtatMort());
				}else{
					this.grille[x][y]=new Cellule(x,y,new CelluleEtatVivant());
				}
			}
		}
	}
	/**
	 * mise à zéro de la grille
	 */
	public void miseZeroGrille(){
		for(int x=0; x<this.xMax; x++){
			for(int y=0;y<this.yMax;y++){
				this.grille[x][y]=new Cellule(x,y,new CelluleEtatMort());
			}
		}
	}
	public Cellule getGrilleXY(int x, int y){
		if((x>=0 && x<this.xMax) && (y>=0 && y<this.yMax)){
			return this.grille[x][y];
		}
		return null;
	}
	/**
	 * nbCelluleV compte le nombre de cellule vivante dans la grille
	 * @Return Int le nombre de cellule vivante
	 */
	 public int nbCelluleV(){
	 	int ret=0;
	 	for(Cellule[] col:this.grille){
	 		for(Cellule c: col){
	 			if(c.estVivante()){
	 				ret++; 
	 			}
	 		}
	 	}
	 	return ret;
	 }
	/**
	 * attacheObservateur permet d'ajouter un observateur à la liste d'observateur
	 * @param Observaeur à  ajouter
	 */
	public void attacheObservateur(Observateur o){
		this.observateur.add(o);
	}
	/**
	 * detacheObservateur permet de suprimer un observateur
	 * @param Observateur à supprimer
	 */
	public void detacheObservateur(Observateur o){
		this.observateur.remove(o);
	}
	/**
	 * notifieObservateur permet d'aficher tout les observateurs
	 */
	public void notifieObservateurs(){
		for(Observateur o: this.observateur){
			o.actualise();
		}
	}
	/**
	 * ajouteCommande permet d'ajouter une comande
	 * @param Commande à ajouter
	 */
	 public void ajouteCommande(Commande c){
		this.commandes.add(c);
	}
	/**
	 * detacheObservateur permet de suprimer un observateur
	 * @param Observateur à supprimer
	 */
	public void executeCommande(){
		for(Commande c: this.commandes){
			c.executer();
		}
	}
	/**
	 * distribueVisiteur permet de regarder le nouvelle etat de chaque cellule
	 */
	 public void distribueVisiteur(){
	 	for(int x=0; x<xMax ; x++){
	 		
	 		for(int y=0; y<yMax ;y++){
	 			this.grille[x][y].accepte(this.vis);
	 		}
	 	}
	 }
	 /**
	  * calculerGenerationSuivante permet d'actualiser le tableau
	  */
	  public void calculerGenerationSuivante(){
	  			this.distribueVisiteur();
	  			this.executeCommande();
	  }

}