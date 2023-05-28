package com.jeuDeLaVie;

/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Tue Apr 18 11:56:13 CEST 2023
*
*/
import javax.swing.event.*; 
import javax.swing.JSlider; 
public class Slider implements ChangeListener {
	//static JSlider slider;
	
    public static JSlider creatSlider(int min, int max, int val, int pat){
    	// Créer un slider
    	JSlider slider = new JSlider(min,max,val);
    	
		// Peindre la piste(track) et l'étiquette
        slider.setPaintTrack(true); 
        slider.setPaintTicks(true); 
        slider.setPaintLabels(true);  

        // Définir l'espacement
        slider.setMajorTickSpacing(pat); 
        slider.setMinorTickSpacing(100); 
  
        // Associer le Listener au slider
        slider.addChangeListener(new Slider());
        return slider;
    }
    public void stateChanged(ChangeEvent e){  
    }
}