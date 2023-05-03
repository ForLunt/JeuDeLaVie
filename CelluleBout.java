/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Sun Apr 30 13:43:39 CEST 2023
*
*/
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.*;
public class CelluleBout extends JButton  {
	private int x;
	private int y;
	private JeuDeLaVie j;
	CelluleBout(int x,int y,JeuDeLaVie j){
		super("");
		this.x=x;
		this.y=y;
		this.j=j;
		
	}
	public void action(){
		if(this.getBackground().equals(Color.BLUE)){
			this.setBackground(null);
			j.getGrilleXY(x,y).meurt();
		}else{
			this.setBackground(Color.BLUE);
			j.getGrilleXY(x,y).vit();
		}
		j.notifieObservateurs();
	}
}