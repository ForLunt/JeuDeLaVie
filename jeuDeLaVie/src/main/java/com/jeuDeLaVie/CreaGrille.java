package com.jeuDeLaVie;

/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Tue Apr 25 15:43:22 CEST 2023
*
*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.event.*;

public class CreaGrille extends JFrame implements ActionListener{
	static JFrame f;
	private JPanel panBout;
	private JeuDeLaVie j;
	private CelluleBout[][] grille;
	private Pochoir forme=null;
	
	CreaGrille(JeuDeLaVie j){
		this.j=j;
		f = new JFrame();
        f.setTitle("Création d'une grille");
        f.setSize(1300, 1400);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null); 
    	// setting grid layout of 3 rows and 3 columns
    	//gration de la grille
    	this.grille=new CelluleBout[this.j.getXMax()][this.j.getYMax()];
    	//Création du pannel des bouton de pochoir
    	JPanel poch = new JPanel();
    	poch.setBorder(BorderFactory.createTitledBorder("Pochoir"));
    	BoxLayout layoutPoch = new BoxLayout(poch, BoxLayout.X_AXIS);
    	poch.setLayout(layoutPoch);
    	//créationdu pannel contenant la grille
    	panBout=new JPanel();
    	//this.panBout.setMaximumSize(new Dimension(300,600));
    	panBout.setLayout(new GridLayout(this.j.getYMax(),this.j.getXMax()));
 
    	//création de box
    	Box vBox = Box.createVerticalBox();
		Box hBox = Box.createHorizontalBox();

		//création des bouton de proposition de forme
		JButton planeur = new JButton("Planeur");
        planeur.addActionListener(this);
        JButton u = new JButton("U");
        u.addActionListener(this);
        JButton clignotteH= new JButton("-");
        clignotteH.addActionListener(this);
        JButton clignotteV= new JButton("|");
        clignotteV.addActionListener(this);
        JButton carrer= new JButton("□");
        carrer.addActionListener(this);
        JButton normal= new JButton("sans Pochoir");
        normal.addActionListener(this);

        vBox.add(planeur);
        vBox.add(u);
        vBox.add(clignotteH);
        vBox.add(clignotteV);
        vBox.add(carrer);
        vBox.add(normal);
        poch.add(vBox);
		hBox.add(poch);
		hBox.add(panBout);
		f.add(hBox);
	}

	public void initialiseGrid(){
		for(int y=0; y<this.j.getYMax(); y++){
			for(int x=0;x<this.j.getXMax();x++){
				int saveX=x;
				int saveY=y;
				CelluleBout cellule =new CelluleBout(x,y,this.j);
				cellule.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(forme!=null){
							Pochoir tmp = forme;
							forme=null;
							tmp.creatForme(grille,saveX,saveY);
							forme=tmp;
						}else{
							cellule.action();
						}
					}
				});
				this.grille[x][y]=cellule;
				panBout.add(this.grille[x][y]);
			}
		}
	}
	
	public void actionPerformed(ActionEvent e){
		String s = e.getActionCommand();
		if(s.equals("Planeur")){
			this.forme=new PochoirPlanneur();
		}
		else if(s.equals("U")){
			this.forme=new PochoirU();
		}
		else if(s.equals("-")){
			this.forme=new PochoirClignotteH();
		}
		else if(s.equals("|")){
			this.forme=new PochoirClignotteV();
		}
		else if(s.equals("□")){
			this.forme=new PochoirCarrer();
		}
		else if(s.equals("sans Pochoir")){
			this.forme=null;
		}
	}
	public void afficherCrea(){
		this.j.miseZeroGrille();
        this.initialiseGrid();
		f.setVisible(true);
	}
	
}