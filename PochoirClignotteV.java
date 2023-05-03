/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Sun Apr 30 14:37:11 CEST 2023
*
*/
public class PochoirClignotteV implements Pochoir {
	public void creatForme(CelluleBout [][] grille,int x, int y){
		(grille[x][y-1]).action();
		(grille[x][y]).action();
		(grille[x][y+1]).action();
	}
}