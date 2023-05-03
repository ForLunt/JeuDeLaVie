/**
* @author Pechon
* @version 0.1 : Date : Thu Apr 13 09:24:32 CEST 2023
*
*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*; 
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JColorChooser;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.*;

import java.util.concurrent.TimeUnit;


public class Interface extends JFrame implements ActionListener{
	static JFrame frame;
	private JButton col;
	private JButton play;
	private JButton redo;
	private JeuDeLaVie j;
	//private CreaGrille creaG;
	private JeuDeLaVieUI jUI ;
	private Boolean joue;
	private JSlider zoom;
	private JTextField larg;
	private JTextField haut;
	Interface(){
		this.j=new JeuDeLaVie();
		this.j.initialiseGrille();
		this.jUI=new JeuDeLaVieUI(j);
		this.j.attacheObservateur(this.jUI);
		this.joue=false;
	}
	public void initialisation(){
		//Initialisation de la Frame
		frame = new JFrame("Option");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Calcule la dimention parapore à la taille de l'écrant
		Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
		int longueur = tailleMoniteur.width * 1/2;
		int hauteur = tailleMoniteur.height * 1/2;
		frame.setSize(longueur, hauteur);

		//Initialisation des panel
		JPanel sec1 = new JPanel();
        JPanel sec2  = new JPanel();
        JPanel sec3 = new JPanel();
        JPanel sec4 = new JPanel();
        JPanel sec5 = new JPanel();
        JPanel taille = new JPanel();
        JPanel coul = new JPanel();
        //JPanel pan = new JPanel();
        //Création des box
        sec1.setBorder(BorderFactory.createTitledBorder("Règle"));
        sec2.setBorder(BorderFactory.createTitledBorder("Gestion Grille"));
        sec3.setBorder(BorderFactory.createTitledBorder("Vitesse"));
        sec4.setBorder(BorderFactory.createTitledBorder("zoom"));
        taille.setBorder(BorderFactory.createTitledBorder("taille"));
        coul.setBorder(BorderFactory.createTitledBorder("Couleur"));
        //positionnement des panel
        BoxLayout layout1 = new BoxLayout(sec1, BoxLayout.Y_AXIS);
        BoxLayout layout2 = new BoxLayout(sec2, BoxLayout.Y_AXIS);
        BoxLayout layout3 = new BoxLayout(sec3, BoxLayout.Y_AXIS);
        BoxLayout layout4 = new BoxLayout(sec4, BoxLayout.Y_AXIS);
        BoxLayout layoutTail = new BoxLayout(taille, BoxLayout.Y_AXIS);
        BoxLayout layoutCoul = new BoxLayout(coul, BoxLayout.Y_AXIS);
        //ajout des layout au panel
        sec1.setLayout(layout1);
        sec2.setLayout(layout2);
        sec3.setLayout(layout3);
        sec4.setLayout(layout4);
        taille.setLayout(layoutTail);
        coul.setLayout(layoutCoul);

        //Definition des diférente action
        //listing des diférentes règle
        JComboBox<String> choixReg= new JComboBox<String>();
        choixReg.addItem("Classique");
        choixReg.addItem("Day&Nigth");
        //Création d'un bouton pour des couleurs
        this.col= new JButton("");
        col.setBackground(Color.BLUE);
        col.addActionListener(this);
        //Création des sliders bar
        JSlider vit= Slider.creatSlider(0,1000,500,200);
        this.zoom= Slider.creatSlider(1,10,1,1);

        //Création des boutons
        JButton modifGrill = new JButton("Création de la Grille");
        modifGrill.addActionListener(this);
		this.play = new JButton("Play");
		this.play.addActionListener(this);
		this.redo = new JButton(">>");
        this.redo.addActionListener(this);
        JButton plus = new JButton("+");
        plus.addActionListener(this);
        JButton moins = new JButton("-");
        moins.addActionListener(this);
        JButton rest = new JButton("rest");
        rest.addActionListener(this);
        JButton valid = new JButton("OK");
        valid.addActionListener(this);
        JButton explication = new JButton("?");
        explication.addActionListener(this);
        explication.setAlignmentX(Component.RIGHT_ALIGNMENT);
        //Initialisation textField
        this.larg= new JTextField("145");
        this.haut= new JTextField("100");
        //Création de de box
		Box vBox = Box.createVerticalBox();
		Box hBox = Box.createHorizontalBox();
		Box hBS4 = Box.createHorizontalBox();
		Box hB2S2 = Box.createHorizontalBox();
		Box hBS2 = Box.createHorizontalBox();
        //Ajout des action dans chaque section
        //sec1 Règle
        choixReg.setAlignmentX(Component.LEFT_ALIGNMENT);
        sec1.add(choixReg);
        //sec2 couleur
        hBS2.add(this.larg);
        hBS2.add(new JLabel("X"));
        hBS2.add(this.haut);
        hBS2.add(valid);
        taille.add(hBS2);
        coul.add(col);
        hB2S2.add(coul);
        sec2.add(taille);
        sec2.add(hB2S2);
        //sec3 vitesse
        sec3.add(vit);
        //sec4 zoom
        hBS4.add(moins);
        hBS4.add(zoom);
        hBS4.add(plus);
        sec4.add(hBS4);
        //sec5 pause
        sec5.add(rest);
        sec5.add(modifGrill);
        sec5.add(this.play);
        sec5.add(this.redo);
		//ajout des panel à la frame
		//frame.setLayout(new FlowLayout());
		
		hBox.add(explication);
		hBox.add(sec1);
		hBox.add(sec2);
		vBox.add(hBox);
		vBox.add(sec4);
		vBox.add(sec3);
		vBox.add(sec5);
		frame.add(vBox);

		//Création visuel de la frame
		frame.pack();
		frame.setVisible(true);
		
		this.j.notifieObservateurs();
		int zoomVal=this.zoom.getValue();
		this.jUI.setTail(this.zoom.getValue());
		while(frame.isVisible()){
			
			if(this.play.getText().equals("||")){
				try{
					this.regle(choixReg);
					this.j.calculerGenerationSuivante();
					int time =200+vit.getValue();
					this.j.notifieObservateurs();
					TimeUnit.MILLISECONDS.sleep(time);
				}catch(InterruptedException e) {
					e.printStackTrace();
				} 
			}
			if(this.zoom.getValue()!=zoomVal){
				this.jUI.setTail(this.zoom.getValue());
				zoomVal=this.zoom.getValue();
				this.j.notifieObservateurs();
			}
			System.out.print("");
		}
	}
	public void regle(JComboBox<String>  co){
		this.j.modVis(switch( co.getSelectedIndex()){
			case 0 ->new VisiteurClassique(this.j);
			case 1 ->new VisiteurDayAndNigth(this.j);
			default ->  throw new IllegalStateException((String)co.getSelectedItem()+"est faux");
		});
	}
	public void actionPerformed(ActionEvent e){
	  	String s = e.getActionCommand();
	  	if(s.equals("Play")){
	  		this.play.setText("||");
	  	}
	  	else if(s.equals("||")){
	  		this.play.setText("Play");
	  	}
	  	else if(s.equals(">>")){
	  		if((this.play.getText()).equals("Play")){
	  			this.j.calculerGenerationSuivante();
	  			this.j.notifieObservateurs();
	  		}
	  	}
	  	else if(s.equals("+")){
	  		this.zoom.setValue(this.zoom.getValue()+1);
	  		this.jUI.setTail(this.zoom.getValue());
	  		this.j.notifieObservateurs();
	  	}
	  	else if(s.equals("-")){
	  		this.zoom.setValue(this.zoom.getValue()-1);
	  		this.jUI.setTail(this.zoom.getValue());
	  		this.j.notifieObservateurs();
	  	}
	  	else if(s.equals("Création de la Grille")){
	  		CreaGrille creaG = new CreaGrille(this.j);
	  		creaG.afficherCrea();
	  		//if(this.j.nbCelluleV() == 0){
	  			//this.j.initialiseGrille();
	  		//}
	  		this.j.notifieObservateurs();
	  	}
	  	else if(s.equals("rest")){
	  		this.j.miseZeroGrille();
	  		this.j.initialiseGrille();
	  		this.j.notifieObservateurs();
	  	}
	  	else if(s.equals("OK")){
	  		this.j.setXMax(Integer.valueOf(larg.getText()));
	  		this.j.setYMax(Integer.valueOf(haut.getText()));
	  		int nbCell=Integer.valueOf(larg.getText())*Integer.valueOf(haut.getText());
	  		
	  		if(nbCell>=1000){
	  			this.jUI.setTailOr(6);
	  		}
	  		else if(nbCell>=100){
	  			this.jUI.setTailOr(60);
	  		}
	  		else{
	  			this.jUI.setTailOr(100);
	  		}
	  		this.jUI.setTail(1);
	  		this.j.initialiseGrille();
	  		this.j.notifieObservateurs();
	  		//System.out.println(larg.getText()+"X"+this.haut.getText());
	  	}
	  	else if(s.equals("?")){
	  		ExplicationLog exp= new ExplicationLog();
	  		exp.afficherExp();
	  	}
	  	else if(s.equals("")){
	  		Color init = this.col.getBackground();
	  		Color couleur = JColorChooser.showDialog(this,"Choisissez une couleur",init);
	  		this.jUI.setColor(couleur);
	  		this.j.notifieObservateurs();
	  		if(couleur==null){
	  			this.col.setBackground(init);
	  		}else{
	  			this.col.setBackground(couleur);
	  		}
	  	}
	}

	public static void main(String[] args){
		   Interface i = new Interface();
		   i.initialisation();
	}
}