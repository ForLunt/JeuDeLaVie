package com.jeuDeLaVie;

/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Sun Apr 30 14:31:39 CEST 2023
*
*/
public class PochoirClignotteH implements Pochoir{
	public void creatForme(CelluleBout [][] grille,int x, int y){
		(grille[x-1][y]).action();
		(grille[x][y]).action();
		(grille[x+1][y]).action();
	}
}