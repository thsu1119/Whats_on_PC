package com.uk.whatson.client.gui;
import java.awt.*;

import javax.swing.*; 

/**@author ajpc500
 * @version 1.0
 * @since 13-03-13 **/

/**Class used to populate the scrollpane of ads in MainWindow
 * It takes an image,theme color and event information and creates a list element.**/


@SuppressWarnings("serial")

public class ListElement extends JButton {

      static Font font1 = new Font("Arial Black", Font.PLAIN, 25);
      static Font font2 = new Font("Arial", Font.PLAIN, 18);
      static Font font3 = new Font("Arial", Font.PLAIN, 16);
	  Image listPicture; Image background; 
	  static JLabel info = new JLabel();
	  static JLabel adtitle = new JLabel();
	  static JLabel datelabel1 = new JLabel();
	  static JLabel locationlabel = new JLabel();
      static Color white = new Color(255,255,255);
      static Color black = new Color(0,0,0);
      static Color grey = new Color(150,150,150);
      static JPanel listElement = new JPanel();

		
      public ListElement(String imagepath, Color theme, String title, String subtitle, String date, String location) // the frame constructor method
	  {
    	isFocusable();
    	setLayout(null);
		setSize(400,80);
	    setBackground(white);
	    
	    ImagePanel listPicture = new ImagePanel(imagepath);
	    
	    listPicture.setLocation(6,7); 
	    listPicture.setOpaque(true);
	    listPicture.setSize(71,67);
	    add(listPicture);
		
		JPanel listThemeLine = new JPanel();
		listThemeLine.setLayout(null);
		listThemeLine.setSize(399,5);
        listThemeLine.setLocation(3,74);
        Color line = new Color(160,32,60);
        
        listThemeLine.setBackground(theme);
        add(listThemeLine);
        
        JPanel listThemePicture = new JPanel();
        listThemePicture.setLayout(null);
        listThemePicture.setSize(78,70);
        listThemePicture.setLocation(3,4);
        listThemePicture.setBackground(theme);
        add(listThemePicture);
		
        
        adtitle = new JLabel();
        adtitle.setLocation(90,-2);
        adtitle.setText(title);
        adtitle.setFont(font1);       
        adtitle.setForeground(black);
        adtitle.setSize(adtitle.getPreferredSize());
        add(adtitle);         
        
        info = new JLabel();
        info.setLocation(90,25);
        info.setText(subtitle);
        info.setFont(font2);       
        info.setForeground(line);
        info.setSize(info.getPreferredSize());
        add(info); 
        
        datelabel1 = new JLabel();
        datelabel1.setLocation(316,40);
        datelabel1.setText(date);
        datelabel1.setFont(font3);       
        datelabel1.setForeground(grey);
        datelabel1.setSize(datelabel1.getPreferredSize());
        add(datelabel1);
        
        locationlabel = new JLabel();
        locationlabel.setLocation(316,55);
        locationlabel.setText(location);
        locationlabel.setFont(font3);       
        locationlabel.setForeground(grey);
        locationlabel.setSize(locationlabel.getPreferredSize());
        add(locationlabel);
        
	    listElement.setBackground(white);
	    listElement.setOpaque(true);}     
}

