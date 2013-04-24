package com.uk.whatson.client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**@author ajpc500
 * @version 1.0
 * @since 13-03-13 **/

/**Class used to create the slideshow elements present in the main slide. 
 * The future version of this class will incorporate the functionality of passing it 
 * pictures, text and colors to populate it with the relevant material. Currently it is 
 * just a static example as proof of concept. **/
@SuppressWarnings("serial")
public class SlideShowElements extends JPanel {

    static Font font1 = new Font("Arial Black", Font.PLAIN, 40);
    static Font font3 = new Font("Arial", Font.PLAIN, 16);

	
	JPanel slideShowFull= new JPanel();
	CustomButton button1 = new CustomButton();
	CustomButton button2 = new CustomButton();
	CustomButton button3 = new CustomButton();
	CustomButton button4 = new CustomButton();
	CustomButton button5 = new CustomButton();
	
	JTextArea slideText = new JTextArea();
	JPanel slideInformation = new JPanel();
	Image slideimage; 
	
	public SlideShowElements(){
	
		//setBackground(new Color(77,175,247));

		setSize(1007,260);
		setLayout(null);
		
		slideInformation = new JPanel();
		slideInformation.setSize(282,260);
		slideInformation.setLocation(605,0);
		slideInformation.setLayout(null);
		slideInformation.setOpaque(true);
		slideInformation.setBackground(new Color(77,175,247));
		    
		JLabel slidelabel = new JLabel();
		slidelabel.setFont(font1);
		slidelabel.setText("TITLE");
		slidelabel.setBackground(new Color(77,175,247));
		slidelabel.setForeground(Color.black);
		slidelabel.setLocation(5,0);
		slidelabel.setSize(282,60);
		slideInformation.add(slidelabel);			
		
		slideText = new JTextArea();
		
		slideText.setSize(282, 200);
		slideText.setBackground(new Color(77,175,247));
		slideText.setFont(font3);
		slideText.setText("INFORMATION GOES HERE." 
							+ "\n\nAND HERE," 
							+ "\n\n\n...AND HERE.");
		slideText.setLineWrap(true);
		slideText.setForeground(Color.white);
		slideText.setEditable(false);
		slideText.setLocation(5,60);
		slideInformation.add(slideText);
		
		add(slideInformation);
		
		button1 = new CustomButton();
		button2 = new CustomButton();
		button3 = new CustomButton();
		button4 = new CustomButton();
		button5 = new CustomButton();

		button1.customImageButton("Images/slide1.png");
		button2.customImageButton("Images/slide2.png");
		button3.customImageButton("Images/slide3.png");
		button4.customImageButton("Images/slide4.png");
		button5.customImageButton("Images/slide5.png");
		
		button1.setSize(120,52);
		button2.setSize(120,52);
		button3.setSize(120,52);
		button4.setSize(120,52);
		button5.setSize(120,52);
		

		button1.setLocation(887,0);
		button2.setLocation(887,52);
		button3.setLocation(887,104);
		button4.setLocation(887,156);
		button5.setLocation(887,208);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		
		

	    ImagePanel slideimage = new ImagePanel("Images/slidepicture.png");
	    slideimage.setSize(605,260);
	    slideimage.setLocation(0,0);
	    add(slideimage);
		
	   

	    
		revalidate();		
		
	}

	
	
	
}
