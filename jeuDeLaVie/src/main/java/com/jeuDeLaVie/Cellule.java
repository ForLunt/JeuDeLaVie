package com.jeuDeLaVie;

/**
* @author Pechon
* @version 0.1 : Date : Mon Apr 03 11:05:45 CEST 2023
*
*/
public class Cellule {
	//coordonnée de la cellule
	private int x;
	private int y;
	//Etat de la cellule
	private CelluleEtat etat;
	//constructeur de cellule
	Cellule(int x, int y, CelluleEtat etat){
		this.etat= etat;
		this.x=x;
		this.y=y;
	}

	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	/**
	 * vit permet de rendre vivante une cellule
	 */
	public void vit(){
		etat=etat.vit();
	}
	/**
	 * meurt permet de faire mourir une cellule
	 */
	public void meurt(){
		etat=etat.meurt();
	}
	/**
	 * estVivante permet de regarder si une cellule est vivante ou non
	 * @return Boolean
	 */
	public Boolean estVivante(){
		return etat.estVivante();
	}
	/**
	 * nombreVoisineVivantes permet de connaitre les voisine vivante d'une  cellule 
	 * @param JeuDeLaVie pour avoir les voisine de la cellule
	 * @return le nombre de voisine
	 */
	 public int nombreVoisinesVivantes(JeuDeLaVie jeu){
	 	int nbCel=0;
	 	for(int x= -1;x<=1;x++){
	 		for(int y= -1;y<=1;y++){
	 			int calX=this.getX()+x;
	 			int calY=this.getY()+y;
	 				Cellule voisine = jeu.getGrilleXY(calX,calY);
	 					if(voisine!=null){
	 						if(voisine.estVivante()){
	 							nbCel++;
	 						}
	 					}
	 		}
	 	}
	 	if(this.estVivante()){
	 		nbCel--;
	 	}
	 	return nbCel;
	 }
	 /**
	 * accepte permet d'invoquer la methode du visiteur correspondent
	 */
	 public void accepte(Visiteur v){
	 	this.etat.accepte(v,this);
	 }
}