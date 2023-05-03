/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Sun Apr 30 11:34:55 CEST 2023
*
*/
public class PochoirPlanneur implements Pochoir{
	public void creatForme(CelluleBout [][] grille, int x, int y){
		(grille[x][y-1]).action();
		(grille[x-1][y]).action();
		(grille[x-1][y+1]).action();
		(grille[x][y+1]).action();
		(grille[x+1][y+1]).action();
	}
}