/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Sun Apr 30 11:35:06 CEST 2023
*
*/
public class PochoirU implements Pochoir{	
	public void creatForme(CelluleBout [][] grille,int x, int y){
		(grille[x-1][y-1]).action();
		(grille[x-1][y]).action();
		(grille[x-1][y+1]).action();
		(grille[x][y+1]).action();
		(grille[x+1][y+1]).action();
		(grille[x+1][y]).action();
		(grille[x+1][y-1]).action();
	}
}