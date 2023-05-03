/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Sun Apr 30 15:37:41 CEST 2023
*
*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*; 
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Font;

import java.io.*;
public class ExplicationLog  extends JFrame {
	static JFrame f;
	ExplicationLog(){
		f = new JFrame();
        f.setTitle("Création d'une grille");
        f.setSize(1300, 500);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        JTextArea sb = new JTextArea();
        JPanel p =new JPanel();
        Box vBox = Box.createVerticalBox();
       try{
	      // Le fichier d'entrée
	      File file = new File("./README.txt");    
	      // Créer l'objet File Reader
	      FileReader fr = new FileReader(file);  
	      // Créer l'objet BufferedReader        
	      BufferedReader br = new BufferedReader(fr);
	      String line;
	      int nbLine=0;
	      Font fo = new Font("Bold", Font.BOLD, 14);
	      sb.setFont(fo);
	      while((line = br.readLine()) != null){
	      	// ajoute la ligne au buffer
	      	sb.append(line+"\n");
	      	nbLine++;
	      }
	      fr.close();
	      sb.setRows(nbLine);
	      sb.setEditable(false);
	      vBox.add(new JLabel("Jeu De La Vie"));
	      vBox.add(sb);
	      p.add(vBox);
	      f.add(p);
	     }catch(IOException e){
	     	e.printStackTrace();
	     }
	}
	public void afficherExp(){
		f.setVisible(true);
	}
}