package com.jeuDeLaVie;

/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Sun Apr 30 14:46:10 CEST 2023
*
*/
public class PochoirCarrer implements Pochoir {
	public void creatForme(CelluleBout [][] grille,int x, int y){
		(grille[x][y]).action();
		(grille[x][y+1]).action();
		(grille[x+1][y+1]).action();
		(grille[x+1][y]).action();
		
	}
}