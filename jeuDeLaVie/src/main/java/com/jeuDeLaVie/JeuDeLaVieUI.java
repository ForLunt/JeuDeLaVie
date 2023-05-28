package com.jeuDeLaVie;

/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Tue Apr 25 10:57:38 CEST 2023
*
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Dimension;

import javax.swing.JFrame;


public class JeuDeLaVieUI extends JFrame implements Observateur {

	private JeuDeLaVie jeu;
	private Color col;
	private int tail;
	private int tailOr;
	private int w;
	private int h;
	public JeuDeLaVieUI(JeuDeLaVie jeu){
		super("Jeu de la vie");
		this.jeu=jeu;
		this.col=Color.BLUE;
		this.tail=1;
		this.tailOr=6;
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Calcule la dimention parapore à la taille de l'écrant
		Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
		this.w = tailleMoniteur.width * 3/4;
		this.h = tailleMoniteur.height * 2/3;
		this.setSize(w,h);
		this.setVisible(true);
	}

	@Override
	public void actualise(){
		repaint();
	}

	@Override
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(this.col);
		for(int x = 0;x<jeu.getXMax();x++){
			for(int y = 0;y<jeu.getYMax();y++){
				if(jeu.getGrilleXY(x,y).estVivante())
					g.fillOval(x*this.tail+(this.w/8),y*this.tail+(this.h/8),this.tail,this.tail);
			}
		}
	}
	public void setTail(int tail){
		this.tail=tail*this.tailOr;
	}
	public void setTailOr(int tail){
		this.tailOr=tail;
	}
	public void setColor(Color couleur){
		this.col=couleur;
	}
}